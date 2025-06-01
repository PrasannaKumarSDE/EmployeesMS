package com.example.EmployeeM.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files; // Add this import for Files.createDirectories
import java.nio.file.Paths; // Add this import for Paths.get
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException; // Add this import for DateTimeParseException
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.EmployeeM.DTO.EmployeeDetailsDTO;
//import com.example.EmployeeM.DTO.EmployeedetailsDTO; // Corrected DTO name to EmployeedetailsDTO
import com.example.EmployeeM.Entity.EmployeeDetails;
import com.example.EmployeeM.Repository.EmployeeDetailsRepository;

import jakarta.annotation.PostConstruct; // Add this import

@Service
public class EmployeeDetailsService {

	@Autowired
	private EmployeeDetailsRepository repo;

    private static final String FILE_DIR = "C:\\path\\to\\your\\project\\uploads\\";

    // Ensure the upload directory exists on application startup
    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(Paths.get(FILE_DIR));
        } catch (IOException e) {
            throw new RuntimeException("Could not create upload directory: " + FILE_DIR, e);
        }
    }

    public String addEmployee(EmployeeDetailsDTO dto) { // Use EmployeedetailsDTO
        // Input validation for first and last names (though DTO validation should catch this)
        if (dto.getFirstName() == null || dto.getFirstName().trim().isEmpty() ||
            dto.getLastName() == null || dto.getLastName().trim().isEmpty()) {
            throw new RuntimeException("First name and Last name are required for employee creation.");
        }

        String loginId = generateLoginId(dto.getFirstName(), dto.getLastName());
        String empId = generateEmployeeId();

        MultipartFile file = dto.getIdProof();
        // Improve file path to avoid name collisions and preserve original file extension
        String filePath = FILE_DIR + System.currentTimeMillis() + "_" + file.getOriginalFilename();

        // More robust file validation
        if (file.isEmpty()) {
            throw new RuntimeException("ID Proof file cannot be empty.");
        }
        if (!file.getOriginalFilename().toLowerCase().endsWith(".pdf")) {
            throw new RuntimeException("Invalid file type. Only PDF files are allowed.");
        }
        long fileSizeInBytes = file.getSize();
        if (fileSizeInBytes < 10240 || fileSizeInBytes > 1048576) { // 10KB to 1MB
            throw new RuntimeException("PDF file size must be between 10KB and 1MB.");
        }

        try {
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException("File upload failed: " + e.getMessage(), e);
        }

        LocalDate dob;
        try {
            dob = LocalDate.parse(dto.getDob(), DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Invalid date format for Date of Birth. Please use 'dd-MMM-yyyy' (e.g., 01-Jan-1990).");
        }

        if (LocalDate.now().minusYears(18).isBefore(dob)) {
            throw new RuntimeException("Employee must be at least 18 years old.");
        }

        EmployeeDetails emp = new EmployeeDetails();
        emp.setFirstName(dto.getFirstName());
        emp.setMiddleName(dto.getMiddleName());
        emp.setLastName(dto.getLastName());
        emp.setLoginId(loginId);
        emp.setDateOfBirth(dob);
        emp.setDepartment(dto.getDepartment());
        emp.setSalary(dto.getSalary());
        emp.setPermanentAddress(dto.getPermanentAddress());
        emp.setCurrentAddress(dto.getCurrentAddress());
        emp.setIdProofPath(filePath);

        repo.save(emp);
        return empId; // Return the generated empId
    }

    public List<EmployeeDetails> getEmployees() {
        return repo.findAll();
    }

    public EmployeeDetails getEmployee(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found."));
    }

    public void deleteEmployee(Long id) {
        if (!repo.existsById(id)) { // Check if employee exists before deleting
            throw new RuntimeException("Employee with ID " + id + " not found for deletion.");
        }
        repo.deleteById(id);
    }

    private String generateLoginId(String first, String last) {
        // Defensive null and empty checks
        String firstChar = (first != null && !first.trim().isEmpty()) ? first.trim().substring(0, 1) : "";
        String lastNamePart = (last != null && !last.trim().isEmpty()) ? last.trim() : "";

        String base = firstChar + lastNamePart;

        // If after checks, the base is still empty, throw an error
        if (base.isEmpty()) {
            // This scenario should be caught by @NotEmpty DTO validation ideally.
            // If it reaches here, it means validation failed or was bypassed.
            throw new IllegalArgumentException("First name and Last name combined cannot be empty for login ID generation.");
        }

        String loginId = base.toLowerCase();
        Random rand = new Random();

        // Loop to ensure uniqueness for the generated login ID
        while (repo.existsByLoginId(loginId)) {
            loginId = base.toLowerCase() + (100 + rand.nextInt(900)); // Append random 3 digits
        }
        return loginId;
    }

    private String generateEmployeeId() {
        long count = repo.count() + 1; // Get current count and increment for the new employee
        return String.format("EMP%05d", count); // Formats as EMP00001, EMP00002, etc.
    }
}
package com.example.EmployeeM.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeM.DTO.EmployeeDetailsDTO;
import com.example.EmployeeM.Entity.EmployeeDetails;
import com.example.EmployeeM.Service.EmployeeDetailsService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeDetailsController {
    @Autowired
    private EmployeeDetailsService service;

    @PostMapping
    public ResponseEntity<String> add(@ModelAttribute EmployeeDetailsDTO dto) {
        return ResponseEntity.ok(service.addEmployee(dto));
    }

    @GetMapping
    public List<EmployeeDetails> getAll() {
        return service.getEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDetails get(@PathVariable Long id) {
        return service.getEmployee(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.ok("Deleted");
    }
}

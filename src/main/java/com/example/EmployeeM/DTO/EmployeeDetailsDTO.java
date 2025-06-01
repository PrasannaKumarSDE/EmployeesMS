package com.example.EmployeeM.DTO;

import org.springframework.web.multipart.MultipartFile;

public class EmployeeDetailsDTO {
	
	    private String firstName;
	    private String middleName;
	    private String lastName;
	    private String dob;
	    private String department;
	    private Double salary;
	    private String permanentAddress;
	    private String currentAddress;
	    private MultipartFile idProof;
	    
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getMiddleName() {
			return middleName;
		}
		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public Double getSalary() {
			return salary;
		}
		public void setSalary(Double salary) {
			this.salary = salary;
		}
		public String getPermanentAddress() {
			return permanentAddress;
		}
		public void setPermanentAddress(String permanentAddress) {
			this.permanentAddress = permanentAddress;
		}
		public String getCurrentAddress() {
			return currentAddress;
		}
		public void setCurrentAddress(String currentAddress) {
			this.currentAddress = currentAddress;
		}
		public MultipartFile getIdProof() {
			return idProof;
		}
		public void setIdProof(MultipartFile idProof) {
			this.idProof = idProof;
		}
}

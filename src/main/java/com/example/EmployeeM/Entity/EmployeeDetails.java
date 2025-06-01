package com.example.EmployeeM.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeDetails {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String middleName;
	private String LastName;
	private String loginId;
	private LocalDate dateOfBirth;
	private String department;
	private Double salary;
	private String permanentAddress;
	private String currentAddress;
	private String idProofPath;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	public String getIdProofPath() {
		return idProofPath;
	}
	public void setIdProofPath(String idProofPath) {
		this.idProofPath = idProofPath;
	}
	public EmployeeDetails() {
		
	}
	public EmployeeDetails(String firstName, String middleName, String lastName, String loginId,
			LocalDate dateOfBirth, String department, Double salary, String permanentAddress, String currentAddress,
			String idProofPath) {
		this.firstName = firstName;
		this.middleName = middleName;
		LastName = lastName;
		this.loginId = loginId;
		this.dateOfBirth = dateOfBirth;
		this.department = department;
		this.salary = salary;
		this.permanentAddress = permanentAddress;
		this.currentAddress = currentAddress;
		this.idProofPath = idProofPath;
	}
}

package com.example.EmployeeM.Controller; // Or a new package like com.example.EmployeeM.Web

import com.example.EmployeeM.DTO.EmployeeDetailsDTO;
import com.example.EmployeeM.Service.EmployeeDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @Autowired
    private EmployeeDetailsService employeeDetailsService; // Inject if you plan to list employees

    @GetMapping("/employees/new")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employeeDTO", new EmployeeDetailsDTO());
        return "add_employee";
    }

    @GetMapping("/employees")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeDetailsService.getEmployees());
        return "list_employees"; // You would create this HTML too
    }
    
}
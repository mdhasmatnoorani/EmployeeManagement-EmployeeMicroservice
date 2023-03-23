package com.springjwtsecurity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springjwtsecurity.model.Employee;
import com.springjwtsecurity.repo.EmployeeRepository;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/employee")
public class EmployeeDetailsController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@GetMapping("/allemployees")
	public List<Employee> getAllEmp(){
		List<Employee> allemp = employeeRepository.findAll();
		return allemp;
	}
	
	@GetMapping("/{email}")
	public Optional<Employee> getEmpById(@PathVariable("email") String email) {
		return employeeRepository.findById(email);
	}
	
}

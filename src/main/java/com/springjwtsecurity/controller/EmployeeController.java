package com.springjwtsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springjwtsecurity.jwt.JwtUtil;
import com.springjwtsecurity.model.Employee;
import com.springjwtsecurity.repo.EmployeeRepository;
import com.springjwtsecurity.security.EmployeeLoginDetails;
import com.springjwtsecurity.security.EmployeeLoginDetailsService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/employee/auth")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil jwtUtils;
	
	@Autowired
	EmployeeLoginDetailsService employeeLoginDetailsService;
	
	@PostMapping("/add")
	public String addEmployee(@RequestBody Employee emp) {
		try {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encPass = encoder.encode(emp.getPassword());
		emp.setPassword(encPass);
		employeeRepository.save(emp);
		return "Employee Added Successfully!";
		} 
		catch (Exception e){
			e.printStackTrace();
			return "Could not add Employee!";
		}			
	}
	
	@PostMapping("/authenticate")
	public String authenticate(@RequestBody Employee employee) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(employee.getEmployeeId(), employee.getPassword()));
			if(authentication.isAuthenticated()) {
				EmployeeLoginDetails empLoginDetails = (EmployeeLoginDetails) employeeLoginDetailsService.loadUserByUsername(employee.getEmployeeId()); 
				String token = jwtUtils.generateJwtToken(empLoginDetails); 
				return token;
			}else {
				return "Authentication Failed!";
			}
		}catch(Exception e) {
			return "Authentication Failed! Check username & password.";
		}
	}
}

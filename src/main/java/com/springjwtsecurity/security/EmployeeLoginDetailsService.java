package com.springjwtsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springjwtsecurity.model.Employee;
import com.springjwtsecurity.repo.EmployeeRepository;

@Service
public class EmployeeLoginDetailsService implements UserDetailsService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee emp = employeeRepository.findById(username).get(); 
		return new EmployeeLoginDetails(emp);
	}

}

package com.springjwtsecurity.security;

import com.springjwtsecurity.model.Admin;
import com.springjwtsecurity.model.Employee;
import com.springjwtsecurity.repo.AdminRepository;
import com.springjwtsecurity.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginDetailsService implements UserDetailsService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findById(username).get();
        return new AdminLoginDetails(admin);
    }
}

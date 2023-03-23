package com.springjwtsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjwtsecurity.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}

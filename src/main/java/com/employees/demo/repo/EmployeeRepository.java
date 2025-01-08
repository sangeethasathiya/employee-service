package com.employees.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employees.demo.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}

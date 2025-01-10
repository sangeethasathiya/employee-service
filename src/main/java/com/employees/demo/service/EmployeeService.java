package com.employees.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.employees.demo.dto.Employee;

public interface EmployeeService {

	List<Employee> fetchAllEmployees();

	ResponseEntity<Employee> getEmployee(Integer employeeId);

	Employee saveEmployee(Employee employee);

	ResponseEntity<Employee> updateEmployee(Integer employeeId, Employee employee);

	ResponseEntity<Object> deleteEmployee(Integer employeeId);
}

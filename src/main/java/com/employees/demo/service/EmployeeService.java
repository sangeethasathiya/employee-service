package com.employees.demo.service;

import java.util.List;
import java.util.Optional;

import com.employees.demo.dto.Employee;

public interface EmployeeService {

	List<Employee> fetchAllEmployees();
	
	Optional<Employee> getEmployee(Integer employeeId);
	
	Employee saveEmployee(Employee employee);
	
	Optional<Employee> updateEmployee(Integer employeeId, Employee employee);
	
	boolean deleteEmployee(Integer employeeId);
}

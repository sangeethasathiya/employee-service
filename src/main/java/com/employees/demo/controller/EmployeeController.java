package com.employees.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employees.demo.dto.Employee;
import com.employees.demo.service.EmployeeService;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.fetchAllEmployees();
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer employeeId) {
		return employeeService.getEmployee(employeeId);
	}

	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@PutMapping("/{employeeId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer employeeId,
			@RequestBody Employee updatedEmployee) {
		return employeeService.updateEmployee(employeeId, updatedEmployee);
	}

	@DeleteMapping("/{employeeId}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable Integer employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> entityNotFoundException(EntityNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
}

package com.employees.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employees.demo.dto.Employee;
import com.employees.demo.repo.EmployeeRepository;
import com.employees.demo.service.serviceimpl.EmployeeServiceImpl;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeServiceImpl.fetchAllEmployees();
	}
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer employeeId) {
		return employeeServiceImpl.getEmployee(employeeId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee){
		return employeeServiceImpl.saveEmployee(employee);
	}
	
	@PutMapping("/{employeeId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer employeeId, @RequestBody Employee updatedEmployee){
		return employeeServiceImpl.updateEmployee(employeeId,updatedEmployee)
		.map(employee -> ResponseEntity.ok(employee))
		.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable Integer employeeId){
		return employeeServiceImpl.deleteEmployee(employeeId) == true? ResponseEntity.ok().build(): ResponseEntity.notFound().build();				
	}
}

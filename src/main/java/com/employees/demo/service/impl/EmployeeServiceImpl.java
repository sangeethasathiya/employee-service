package com.employees.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employees.demo.controller.EmployeeController;
import com.employees.demo.dto.Employee;
import com.employees.demo.repo.EmployeeRepository;
import com.employees.demo.service.EmployeeService;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> fetchAllEmployees() {
		log.info("Fetching All Employees Details");
		return employeeRepository.findAll();
	}

	@Override
	public ResponseEntity<Employee> getEmployee(Integer employeeId) {
		log.info("Fetching Employee Details using employeeID : {}", employeeId);
		return employeeRepository.findById(employeeId).map(ResponseEntity::ok)
				.orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		log.info("Saving the Employee Detail to DB");
		return employeeRepository.save(employee);
	}

	@Override
	public ResponseEntity<Employee> updateEmployee(Integer employeeId, Employee updatedEmployee) {
		return employeeRepository.findById(employeeId).map(employee -> {
			employee.setFirstName(updatedEmployee.getFirstName());
			employee.setSecondName(updatedEmployee.getSecondName());
			employee.setAge(updatedEmployee.getAge());
			employee.setDept(updatedEmployee.getDept());
			employee.setSalary(updatedEmployee.getSalary());
			employeeRepository.save(updatedEmployee);
			log.info("Updated the Employee Detail for employee ID : {}", employeeId);
			return ResponseEntity.ok(employee);
		}).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public ResponseEntity<Object> deleteEmployee(Integer employeeId) {
		return employeeRepository.findById(employeeId).map(employee -> {
			employeeRepository.delete(employee);
			return ResponseEntity.ok().build();
		}).orElseThrow(EntityNotFoundException::new);
	}

}

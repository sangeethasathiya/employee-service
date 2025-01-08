package com.employees.demo.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employees.demo.controller.EmployeeController;
import com.employees.demo.dto.Employee;
import com.employees.demo.repo.EmployeeRepository;
import com.employees.demo.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;	
	
	@Override
	public List<Employee> fetchAllEmployees() {
		log.info("Fetching All Employees Details");
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployee(Integer employeeId) {
		log.info("Fetching Employee Details using employeeID : {}", employeeId);
		return employeeRepository.findById(employeeId);		
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		log.info("Saving the Employee Detail to DB");
		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> updateEmployee(Integer employeeId, Employee updatedEmployee) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if(employee.isPresent()) {
			employee.get().setFirstName(updatedEmployee.getFirstName());
			employee.get().setSecondName(updatedEmployee.getSecondName());
			employee.get().setAge(updatedEmployee.getAge());
			employee.get().setDept(updatedEmployee.getDept());
			employee.get().setSalary(updatedEmployee.getSalary());
			employeeRepository.save(updatedEmployee);
			log.info("Updated the Employee Detail for employee ID : {}" , employeeId);
		}
		return employee;
	}

	@Override
	public boolean deleteEmployee(Integer employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if(employee.isPresent()) {
			employeeRepository.deleteById(employeeId);
			log.info("Deleted the employee ID : {}" , employeeId);
			return true;
		}
		return false;
	}

}

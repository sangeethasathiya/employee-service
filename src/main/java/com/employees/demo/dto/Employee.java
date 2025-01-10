package com.employees.demo.dto;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

	@Id
	Integer employeeId;
	String firstName;
	String secondName;
	String age;
	String dept;
	BigDecimal salary;
}

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
	private Integer employeeId;
	private String firstName;
	private String secondName;
	private String age;
	private String dept;
	private BigDecimal salary;
}

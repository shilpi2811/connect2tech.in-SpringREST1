package com.journaldev.spring.service;

import java.util.List;

import com.c2t.annotation.basic.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public Employee getDummyEmployee();
	
	public String deleteEmployee(int id);

}

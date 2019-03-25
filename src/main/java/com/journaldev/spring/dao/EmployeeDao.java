package com.journaldev.spring.dao;

import java.util.List;

import com.c2t.annotation.basic.Employee;

public interface EmployeeDao {

	
	public List<Employee> getAllEmployees();
	
	public Employee getDummyEmployee();	
	
	public String deleteEmployee(int id);
}

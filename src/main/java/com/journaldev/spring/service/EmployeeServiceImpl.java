package com.journaldev.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.c2t.annotation.basic.Employee;
import com.journaldev.spring.dao.EmployeeDao;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	@Qualifier(value="employeeDaoImpl")
	EmployeeDao employeeDao;
	
	public List<Employee> getAllEmployees() {	
		return employeeDao.getAllEmployees();	
	}

	@Override
	public Employee getDummyEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.getDummyEmployee();
	}

	@Override
	public String deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeDao.deleteEmployee(id);
	}

}

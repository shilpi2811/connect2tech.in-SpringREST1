package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.c2t.annotation.basic.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	SessionFactory sf;
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		Session session=sf.openSession();
		Query query=session.createQuery("from Employee");
		List<Employee> list=query.list();
		return list;
	}

	@Override
	public Employee getDummyEmployee() {
		// TODO Auto-generated method stub
		Session session=sf.openSession();
		Employee emp = (Employee)session.get(Employee.class, 1l);
		return emp;
	}

	@Override
	public String deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Session session=sf.openSession();
		Employee emp=(Employee)session.get(Employee.class, new Long(id));
		session.delete(emp);
		session.beginTransaction().commit();
		return "deleted";
	}

}

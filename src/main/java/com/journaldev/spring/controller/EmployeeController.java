package com.journaldev.spring.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.Employee2;
import com.c2t.annotation.basic.EmployeeVO;
import com.journaldev.spring.service.EmployeeService;
import com.sun.media.jfxmedia.logging.Logger;

@Controller
public class EmployeeController {

	@Autowired
	SessionFactory sf;
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping(value="/rest/emp/dummy", method=RequestMethod.GET)
	public @ResponseBody Employee getDummyEmployee()
	{
		Map<Integer,Employee> empData=new HashMap<Integer,Employee>();
		//Logger.info("Start getDummyEmployee");
		//Employee emp=new Employee();
		//emp.setId(1l);
		//emp.setFirstname("Shilpi");
		//emp.setLastname("Agrawal");
		//emp.setBirthDate(new java.sql.Date(1996, 06, 23));
		//emp.setCellphone("123456789");
		//empData.put(9999,emp);	
		Session session=sf.openSession();
		Employee emp = (Employee)session.get(Employee.class, 1l);
		return emp;
	}
	
	@RequestMapping(value="/rest/emps", method=RequestMethod.GET)
	public @ResponseBody String getAllEmployee(Model model)
	{		
		model.addAttribute("employees", empService.getAllEmployees());
		return "employeesListDisplay";
	}
	
	@RequestMapping(value="/rest/em/dummy/list", method=RequestMethod.GET)
	public @ResponseBody EmployeeVO getDummyEmployeeList()

	{
		Query q = sf.openSession().createQuery("from Employee");
		List <Employee> list = q.list();
	     EmployeeVO e1=new EmployeeVO();
	     e1.setEmployees(list);
		return e1;
	}
	
	@RequestMapping(value="/rest/emp/{id}", method=RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable("id") int empId)
	{
		Session session=sf.openSession();
		Employee emp=(Employee)session.get(Employee.class, new Long(empId));
		return emp;
		
	}
	
	@RequestMapping(value="/rest/emp/delete/{id}", method=RequestMethod.GET)
	public @ResponseBody String deleteEmployee(@PathVariable("id") int empId)
	{
		empService.deleteEmployee(empId);
		return "Deleted successfully";
		
	}
	
	@RequestMapping(value="/rest/emp/addEmp", method=RequestMethod.GET)
	public @ResponseBody Employee insertEmployee()
	{
		Session session=sf.openSession();
		session.beginTransaction();
		Employee emp=new Employee("Shilpi","Agrawal",new Date(1992/9/02),"12234566");
		Employee2 emp2=new Employee2("Shilpi","Agrawal",new Date(1992/9/02),"12234566");
		session.save(emp);
		session.save(emp2);
		session.getTransaction().commit();
		return emp;
		
	}
	
}

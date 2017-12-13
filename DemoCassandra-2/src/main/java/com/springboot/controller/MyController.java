package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Employee;
import com.springboot.service.EmployeeService;


@RestController
public class MyController {
	@Autowired
	private EmployeeService employeeService;

	public MyController() {
		System.out.println("EmployeeController()");
	}

	@RequestMapping(value = "/employeeCreate", method = RequestMethod.GET)
	Employee create() {
		
		Employee e=new Employee();
		e.setId(2);
		e.setName("lam");
		e.setAge(3);
		e.setSalary(123);
				
		return employeeService.createEmployee(e);
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	void delete(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	List<Employee> findAll() {
		return employeeService.getAllEmployees();
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	Employee findById(@PathVariable("id") int id) {
		return employeeService.getEmployee(id);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	Employee update(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
}

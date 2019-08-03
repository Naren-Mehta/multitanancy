package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/employeeList")
	public List<Employee> getEmployeeList(){
		
		List<Employee> employeeList= employeeService.employeeList();
		return employeeList;
		
	} 
	
	@GetMapping("/employeecount")
	public Integer getTotalCount(){
		
		Integer count= employeeService.getTotalEmployeeCount();
		return count;
	} 
	
}

package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {
	
	List<Employee> employeeList();	
	
	Employee getEmployee(Integer id);
	
	void save(Employee emp);
	
	void delete(Integer id);
	
	Integer getTotalEmployeeCount();

}

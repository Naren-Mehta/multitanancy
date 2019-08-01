package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeDao {
	
		List<Employee> employeeList();	
		
		Employee getEmployee(Integer id);
		
		void save(Employee emp);
		
		void delete(Integer id);

}

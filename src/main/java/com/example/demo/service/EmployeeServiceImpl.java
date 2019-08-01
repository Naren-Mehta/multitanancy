package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Employee;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> employeeList() {
		List<Employee> employeeList= employeeDao.employeeList();
		return employeeList;
	}

	@Override
	public Employee getEmployee(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	
	
}

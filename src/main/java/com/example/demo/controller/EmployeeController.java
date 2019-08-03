package com.example.demo.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.MultiTanancyDemoAppApplication;
import com.example.demo.config.TenantContext;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employeeList")
	public List<Employee> getEmployeeList() {

		String name = "hcl.com";
		List<Employee> employeeList = new ArrayList<Employee>();
		if (name.equals("quinnox.com")) {
			TenantContext.setCurrentTenant("quinnox");
			employeeList = employeeService.employeeList();
		} else if (name.equals("hcl.com")) {
			TenantContext.setCurrentTenant("hcl");
			employeeList = employeeService.employeeList();
		}

		return employeeList;

	}

	@GetMapping("/employeecount")
	public Integer getTotalCount() {

		Integer count = employeeService.getTotalEmployeeCount();
		return count;
	}

}

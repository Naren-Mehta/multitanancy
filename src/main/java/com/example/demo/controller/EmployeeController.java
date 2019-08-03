package com.example.demo.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
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
	public List<Employee> getEmployeeList() {

		String name = "quinnox.com";

		/*
		 * try { if (name.contentEquals("quinnox.com")) { } } catch (IOException e) {
		 * e.printStackTrace(); } catch (SQLException e) { e.printStackTrace(); }
		 */

		List<Employee> employeeList = employeeService.employeeList();
		return employeeList;

	}

	@GetMapping("/employeecount")
	public Integer getTotalCount() {

		Integer count = employeeService.getTotalEmployeeCount();
		return count;
	}

}

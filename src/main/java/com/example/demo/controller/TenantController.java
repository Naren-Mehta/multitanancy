package com.example.demo.controller;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.MultitenantConfiguration;
import com.example.demo.config.MultitenantDataSource;
import com.example.demo.config.TenantContext;

@RestController
@RequestMapping("/tenant")
public class TenantController {
	
	@Autowired
	private MultitenantDataSource source;

	@GetMapping("/setnewtenant")
	public Boolean setCurrentTenant() throws SQLException {
		
		TenantContext.setCurrentTenant("quinnox");
		Connection c=source.getConnection();
		System.out.println(c);
		return true;
	}

}

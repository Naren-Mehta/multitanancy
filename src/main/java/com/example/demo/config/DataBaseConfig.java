package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataBaseConfig {
	
	@Bean(name="dbHCLService")
	@ConfigurationProperties(prefix="spring.dbhclservice")
	public DataSource createTaskServiceDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	
	@Bean(name="dbQuinnoxService")
	@ConfigurationProperties(prefix="spring.dbquinnoxservice")
	@Primary
	public DataSource createProfileServiceDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="jdbcHCLService")
	@Autowired
	public JdbcTemplate createJdbcTemplate_TaskService(@Qualifier("dbHCLService") DataSource hclServiceDS) {
		return new JdbcTemplate(hclServiceDS);
	}
	
	
	@Bean(name="jdbcQuinnoxService")
	@Autowired
	public JdbcTemplate createJdbcTemplate_ProfileService(@Qualifier("dbQuinnoxService") DataSource quinnoxServiceDS) {
		return new JdbcTemplate(quinnoxServiceDS);
	}
	
	

}

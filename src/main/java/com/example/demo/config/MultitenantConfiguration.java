package com.example.demo.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultitenantConfiguration {

	@Autowired
	private DataSourceProperties properties;

	/**
	 * Defines the data source for the application
	 * 
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {

		Map<Object, Object> resolvedDataSources = new HashMap<>();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource("tenants");
		String path = url.getPath();
		File[] files = new File(path).listFiles();

		for (File propertyFile : files) {
			Properties tenantProperties = new Properties();
			DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create(this.getClass().getClassLoader());
			try {

				tenantProperties.load(new FileInputStream(propertyFile));
				String tenantId = tenantProperties.getProperty("name");
				dataSourceBuilder.url(tenantProperties.getProperty("url"))
						.username(tenantProperties.getProperty("username"))
						.password(tenantProperties.getProperty("password"));

				if (properties.getType() != null) {
					dataSourceBuilder.type(properties.getType());
				}
				resolvedDataSources.put(tenantId, dataSourceBuilder.build());
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}

		System.out.println("=resolvedDataSources==" + resolvedDataSources);

		// Create the final multi-tenant source.
		// It needs a default database to connect to.
		// Make sure that the default database is actually an empty tenant database.
		// Don't use that for a regular tenant if you want things to be safe!
		
		TenantContext.setCurrentTenant("quinnox");
		
		MultitenantDataSource dataSource = new MultitenantDataSource();
		dataSource.setDefaultTargetDataSource(defaultDataSource());
		dataSource.setTargetDataSources(resolvedDataSources);

		// Call this to finalize the initialization of the data source.
		dataSource.afterPropertiesSet();
		
		System.out.println("===="+dataSource.determineCurrentLookupKey());
		return dataSource;
	}

	private DataSource defaultDataSource() {

		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create(this.getClass().getClassLoader())
				.driverClassName(properties.getDriverClassName()).url(properties.getUrl())
				.username(properties.getUsername()).password(properties.getPassword());

		if (properties.getType() != null) {
			dataSourceBuilder.type(properties.getType());
		}
		return dataSourceBuilder.build();
	}

}

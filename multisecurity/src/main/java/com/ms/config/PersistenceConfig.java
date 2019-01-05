package com.ms.config;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value="classpath:db.properties")
public class PersistenceConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public DriverManagerDataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/udyog");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return  dataSource;
	}
	
	
	
	@Bean(autowire=Autowire.BY_TYPE)
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		return jdbcTemplate;
	}
}


/*DriverManagerDataSource dataSource =  new DriverManagerDataSource();
dataSource.setDriverClassName("com.mysql.jdbc.Driver");
dataSource.setUrl("jdbc:mysql://localhost:3306/udyog");
dataSource.setUsername("root");
dataSource.setPassword("root");*/


/*DriverManagerDataSource dataSource = new DriverManagerDataSource();
dataSource.setDriverClassName(env.getProperty("driverClassName"));
dataSource.setUrl(env.getProperty("url"));
dataSource.setUsername(env.getProperty("username"));
dataSource.setPassword(env.getProperty("password"));*/
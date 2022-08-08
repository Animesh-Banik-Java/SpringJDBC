package com.spring.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDaoImp;

@Configuration
public class JdbcConfig {
	@Bean("ds")
	public DriverManagerDataSource getConnections() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");//jdbc:mysql://localhost:3306/springjdbc
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getConnections());
		return jdbcTemplate;
	}
	@Bean("studentDao")
	public StudentDaoImp getStudentDao() {
		StudentDaoImp studentDao = new StudentDaoImp();
		studentDao.setTemplate(getJdbcTemplate());
		return studentDao;
	}

}

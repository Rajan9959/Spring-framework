package com.jsp.Jdbc.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.jsp.jdbc")
public class VoterConfig
{
	@Bean("dataSource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/spring5556");
		ds.setUsername("root");
		ds.setPassword("12345");
		return ds;
	}
	
	@Bean("template")
	public JdbcTemplate getJdbcTemplate(DataSource ds)
	{
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(ds); // (OR) jt.setDataSource(getDataSource()); to call Directly
		return jt;
	}
}

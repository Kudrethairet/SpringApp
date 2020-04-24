package com.Plurlsight.conferecedemo.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {

	
	@Bean
	public DataSource dataSource() {
		DataSourceBuilder builder = DataSourceBuilder.create();
		builder.url("jdbc:postgresql://localhost:5432/postgres");
		builder.username("postgres");
		builder.password("hr");
		System.out.println("this is custome to proof Bean");
		return builder.build();
	}
	
	
	
}

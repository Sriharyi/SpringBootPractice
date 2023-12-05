package com.example.database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.extern.java.Log;

@SpringBootApplication
@Log
public class DatabaseApplication implements CommandLineRunner {

	private JdbcTemplate jdbcTemplate;

	public DatabaseApplication(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("database"+jdbcTemplate.toString());
		jdbcTemplate.execute("select 1");
	}

	

}

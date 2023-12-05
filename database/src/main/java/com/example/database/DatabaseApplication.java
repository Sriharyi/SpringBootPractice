package com.example.database;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.extern.java.Log;

@SpringBootApplication
@Log
public class DatabaseApplication implements CommandLineRunner {

	private final DataSource datasource;

	public DatabaseApplication(DataSource datasource) {
		this.datasource = datasource;
	}

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		JdbcTemplate jdbc = new JdbcTemplate(datasource);
		//display all table in console
		jdbc.queryForList("SELECT * FROM person").forEach(row -> log.info(row.toString()));

	}

}
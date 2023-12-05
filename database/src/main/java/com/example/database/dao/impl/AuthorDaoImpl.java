package com.example.database.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.database.dao.AuthorDao;
import com.example.database.domain.Author;

public class AuthorDaoImpl implements AuthorDao{
    
    private final JdbcTemplate jdbcTemplate;
    
    public AuthorDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void create(Author author) {
        jdbcTemplate.update("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)",author.getId(),author.getName(),author.getAge());
    }
}

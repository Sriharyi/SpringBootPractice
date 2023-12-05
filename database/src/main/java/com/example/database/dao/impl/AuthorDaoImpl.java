package com.example.database.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.database.dao.AuthorDao;

public class AuthorDaoImpl implements AuthorDao{
    
    private final JdbcTemplate jdbcTemplate;
    
    public AuthorDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

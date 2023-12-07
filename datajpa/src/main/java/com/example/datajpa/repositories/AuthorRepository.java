package com.example.datajpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.datajpa.domain.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author,Long>{

}

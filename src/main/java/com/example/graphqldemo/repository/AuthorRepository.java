package com.example.graphqldemo.repository;

import com.example.graphqldemo.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> { }

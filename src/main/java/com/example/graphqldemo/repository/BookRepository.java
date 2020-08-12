package com.example.graphqldemo.repository;

import com.example.graphqldemo.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> { }

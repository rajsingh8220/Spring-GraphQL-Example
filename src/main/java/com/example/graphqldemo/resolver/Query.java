package com.example.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphqldemo.domain.Author;
import com.example.graphqldemo.domain.Book;
import com.example.graphqldemo.repository.AuthorRepository;
import com.example.graphqldemo.repository.BookRepository;

public class Query implements GraphQLQueryResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBook() {
        return bookRepository.count();
    }
    public long countAuthors() {
        return authorRepository.count();
    }
}

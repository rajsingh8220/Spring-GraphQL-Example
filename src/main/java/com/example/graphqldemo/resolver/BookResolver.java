package com.example.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphqldemo.domain.Author;
import com.example.graphqldemo.domain.Book;
import com.example.graphqldemo.repository.AuthorRepository;

import java.util.Optional;

public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Optional<Author> getAuthor(com.example.graphqldemo.domain.Book book) {
        return authorRepository.findById(book.getAuthor().getId());
    }
}
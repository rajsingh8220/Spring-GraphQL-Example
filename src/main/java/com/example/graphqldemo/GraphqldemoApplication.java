package com.example.graphqldemo;

import com.example.graphqldemo.domain.Author;
import com.example.graphqldemo.domain.Book;
import com.example.graphqldemo.repository.AuthorRepository;
import com.example.graphqldemo.repository.BookRepository;
import com.example.graphqldemo.resolver.BookResolver;
import com.example.graphqldemo.resolver.Mutation;
import com.example.graphqldemo.resolver.Query;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqldemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqldemoApplication.class, args);
    }


    @Bean
    public BookResolver authorResolver(AuthorRepository authorRepository) {
        return new BookResolver(authorRepository);
    }

    @Bean
    public Query query(AuthorRepository authorRepository, BookRepository bookRepository) {
        return new Query(authorRepository, bookRepository);
    }

    @Bean
    public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        return new Mutation(authorRepository, bookRepository);
    }

    @Bean
    public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository) {
        return (args) -> {
            Author author = new Author("Herbert", "Schildt");
            authorRepository.save(author);

            bookRepository.save(new Book("Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, author));
        };
    }
}

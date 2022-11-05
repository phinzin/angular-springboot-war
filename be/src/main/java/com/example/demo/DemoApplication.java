package com.example.demo;

import com.example.demo.entities.Book;
import com.example.demo.repositories.BookRepository;
import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    CommandLineRunner init(BookRepository bookRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                Book book = new Book(name);
                bookRepository.save(book);
            });
            bookRepository.findAll().forEach(System.out::println);
        };
    }
}

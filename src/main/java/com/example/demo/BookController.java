package com.example.demo;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    private List<Book> books = new ArrayList<>();

    @GetMapping
    public List<Book>getAllBooks() {
        return books;
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        // Find and return a book by ID

        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        // Add a new book to the list
        books.add(book);
        return book;
    }
}



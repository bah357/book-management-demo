package com.example.demo.controller;

import java.util.List;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import jakarta.validation.Valid;
import jakarta.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    public ResponseEntity<String> addBook(@Valid @RequestBody BookDto book) {
        Book newBook = bookService.save(book);
        if (newBook != null) {
            return ResponseEntity.ok("Book added successfully");
        } else {
            return ResponseEntity.badRequest().build(); // or a more descriptive error response
        }
    }

    /*@PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        // Additional logic to ensure you're updating the correct book
        return bookService.save(book);
    }*/

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @GetMapping
    public List<Book> getBooksByAuthor(@QueryParam("author") String author) {
        return bookService.findByAuthor(author);
    }
}

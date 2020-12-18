package com.library.libraryapi.controller;

import com.library.libraryapi.model.dao.dtos.BookDTO;
import com.library.libraryapi.model.dao.entities.Book;
import com.library.libraryapi.model.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{author}")
    public ArrayList<Book> getBooksByAuthor(@PathVariable String author) {
        return bookService.getBooksByAuthor(author);
    }

    @PostMapping("/book")
    public ResponseEntity createBook(@RequestBody BookDTO bookDTO) {
        bookService.createBook(bookDTO);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/book/{title}")
    public BookDTO getBookByTitle(@PathVariable String title) {
        return bookService.getBookByTitle(title);
    }

}

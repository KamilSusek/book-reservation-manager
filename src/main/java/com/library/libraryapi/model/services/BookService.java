package com.library.libraryapi.model.services;

import com.library.libraryapi.model.dao.dtos.BookDTO;
import com.library.libraryapi.model.dao.entities.Author;
import com.library.libraryapi.model.dao.entities.Book;
import com.library.libraryapi.model.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public List<BookDTO> getAllBooks() {
        final List<BookDTO> bookDTOs = new ArrayList<>();

        bookRepository.findAll().forEach(book -> {
            final String title = book.getTitle();
            final Integer numberOfPages = book.getNumberOfPages();
            final String authorName = book.getAuthor().getAuthorName();

            final BookDTO bookDTO = new BookDTO(title, numberOfPages, authorName);

            bookDTOs.add(bookDTO);
        });
        return bookDTOs;
    }

    public BookDTO getBookByTitle(String bookTitle) {
        final Book book = bookRepository.findBookByTitle(bookTitle);
        final String title = book.getTitle();
        final Integer numberOfPages = book.getNumberOfPages();
        final String authorName = book.getAuthor().getAuthorName();

        return new BookDTO(title, numberOfPages, authorName);
    }

    public ArrayList<Book> getBooksByAuthor(String authorName) {
        final Author author = authorService.getAuthorByName(authorName);

       return (ArrayList<Book>) bookRepository.findBooksByAuthor(author).get();
    }

    public boolean createBook(BookDTO bookDTO) {
        final String title = bookDTO.getTitle();
        final Integer numberOfPages = bookDTO.getNumberOfPages();
        final String authorName = bookDTO.getAuthorName();
        final Author author = authorService.createAuthor(authorName);

        final Book book = new Book(title, numberOfPages, author);

        bookRepository.save(book);
        return true;
    }
}

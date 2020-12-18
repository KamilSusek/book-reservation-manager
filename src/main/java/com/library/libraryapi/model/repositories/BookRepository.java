package com.library.libraryapi.model.repositories;

import com.library.libraryapi.model.dao.entities.Author;
import com.library.libraryapi.model.dao.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface BookRepository extends CrudRepository<Book, Long> {

    Book findBookByTitle(String title);

    Optional<Iterable<Book>> findBooksByAuthor(Author author);
}

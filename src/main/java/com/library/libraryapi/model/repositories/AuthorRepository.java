package com.library.libraryapi.model.repositories;

import com.library.libraryapi.model.dao.entities.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Optional<Author> findAuthorByAuthorName(String authorName);
}

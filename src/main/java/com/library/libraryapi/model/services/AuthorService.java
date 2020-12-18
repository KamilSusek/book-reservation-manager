package com.library.libraryapi.model.services;

import com.library.libraryapi.model.dao.dtos.AuthorDTO;
import com.library.libraryapi.model.dao.entities.Author;
import com.library.libraryapi.model.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorDTO> getAllAuthors() {

        List<AuthorDTO> mappedAuthors = new ArrayList<>();

        authorRepository.findAll().forEach(author -> {
            final AuthorDTO authorDTO = new AuthorDTO(author.getAuthorName());
            mappedAuthors.add(authorDTO);
        });

        return mappedAuthors;
    }

    public Author getAuthorByName(String name) {
        return authorRepository.findAuthorByAuthorName(name).orElseThrow(() ->
                {
                    throw new NullPointerException();
                }
        );

    }

    public Author createAuthor(String authorName) {
        final Author author = authorRepository.findAuthorByAuthorName(authorName).orElse(null);

        if (author == null) {
            final Author saveAuthor = new Author(authorName);
            authorRepository.save(saveAuthor);
            return saveAuthor;
        } else {
            return author;
        }
    }
}

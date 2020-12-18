package com.library.libraryapi.controller;

import com.library.libraryapi.model.dao.dtos.AuthorDTO;
import com.library.libraryapi.model.dao.entities.Author;
import com.library.libraryapi.model.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/author/{name}")
    public Author getAuthorByName(@PathVariable String name) {
        return authorService.getAuthorByName(name);
    }

    @GetMapping("/authors")
    public List<AuthorDTO> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping("/author")
    public ResponseEntity createAuthor(AuthorDTO authorDTO) {
        final String authorName = authorDTO.getAuthorName();
        authorService.createAuthor(authorName);

        return ResponseEntity.ok().build();
    }

}

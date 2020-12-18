package com.library.libraryapi.model.dao.dtos;

public class AuthorDTO {
    private String authorName;

    public AuthorDTO(){}

    public AuthorDTO(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}

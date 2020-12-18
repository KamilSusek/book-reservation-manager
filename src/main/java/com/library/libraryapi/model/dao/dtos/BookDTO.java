package com.library.libraryapi.model.dao.dtos;

public class BookDTO {
    private String title;
    private Integer numberOfPages;
    private String authorName;

    public BookDTO() {
    }

    public BookDTO(String title, Integer numberOfPages, String authorName) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}

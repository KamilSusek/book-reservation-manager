package com.library.libraryapi.model.dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(nullable = false)
    private String authorName;

    @OneToMany(mappedBy = "author")
    private Set<Book> books;

    public Author() {
    }

    public Author(String authorName) {
        this.authorName = authorName;
    }

    public Author(String authorName, Set<Book> books) {
        this.authorName = authorName;
        this.books = books;
    }

    public Book addBook(Book book) {
        books.add(book);
        book.setAuthor(this);
        return book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}

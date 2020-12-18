package com.library.libraryapi.model.dao.dtos;

import java.time.LocalDate;

public class ReservationDTO {
    private String bookTitle;
    private LocalDate beginDate;
    private LocalDate endDate;
    private String username;

    public ReservationDTO() {
    }

    public ReservationDTO(String bookTitle, LocalDate beginDate, LocalDate endDate) {
        this.bookTitle = bookTitle;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public ReservationDTO(String bookTitle, LocalDate beginDate, LocalDate endDate, String username) {
        this.bookTitle = bookTitle;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.username = username;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

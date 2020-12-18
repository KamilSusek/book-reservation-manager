package com.library.libraryapi.model.dao.entities;

import com.library.libraryapi.model.dao.dtos.ReservationDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate beginDate;
    @Column(nullable = false)
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User user;


    public Reservation() {
    }

    public Reservation(LocalDate beginDate, LocalDate endDate) {
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Reservation(LocalDate beginDate, LocalDate endDate, User user) {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.user = user;
    }

    public Reservation(ReservationDTO dto) {
        this.beginDate = dto.getBeginDate();
        this.endDate = dto.getEndDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

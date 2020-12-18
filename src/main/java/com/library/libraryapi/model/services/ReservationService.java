package com.library.libraryapi.model.services;

import com.library.libraryapi.model.dao.dtos.ReservationDTO;
import com.library.libraryapi.model.dao.entities.Book;
import com.library.libraryapi.model.dao.entities.Reservation;
import com.library.libraryapi.model.dao.entities.User;
import com.library.libraryapi.model.repositories.BookRepository;
import com.library.libraryapi.model.repositories.ReservationRepository;
import com.library.libraryapi.model.validation.exceptions.BadReservationDateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final BookRepository bookRepository;
    private final UserService userService;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, BookRepository bookRepository, UserService userService) {
        this.reservationRepository = reservationRepository;
        this.bookRepository = bookRepository;
        this.userService = userService;
    }

    public List<Reservation> getAllReservations() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    public Reservation createReservation(ReservationDTO reservationDTO) throws BadReservationDateException {

        final Book book = bookRepository.findBookByTitle(reservationDTO.getBookTitle());
        final User user = userService.createUser(reservationDTO.getUsername());
        final List<Reservation> reservations = (List<Reservation>) book.getReservations();

        if (isDateValid(reservationDTO.getBeginDate(), reservationDTO.getEndDate())
                && areDatesNotDuplicated(reservationDTO.getBeginDate(), reservations)) {
            Reservation reservation = new Reservation(reservationDTO);
            reservation.setUser(user);
            this.reservationRepository.save(reservation);
            book.addReservation(reservation);
            this.bookRepository.save(book);

            return reservation;
        } else {
            throw new BadReservationDateException("Provided date is wrong", 400);
        }
    }

    private boolean areDatesNotDuplicated(LocalDate start, List<Reservation> reservations) {
        for (Reservation r : reservations) {
            if (!r.getBeginDate().isAfter(start)) {
                return false;
            }
        }
        return true;
    }

    private boolean isDateValid(LocalDate start, LocalDate end) {
        final LocalDate now = LocalDate.now();
        if (start.isBefore(end) && start.isAfter(now)) {
            return true;
        } else {
            return false;
        }
    }
}

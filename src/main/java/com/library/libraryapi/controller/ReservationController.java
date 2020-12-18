package com.library.libraryapi.controller;

import com.library.libraryapi.model.dao.dtos.ReservationDTO;
import com.library.libraryapi.model.dao.entities.Reservation;
import com.library.libraryapi.model.services.ReservationService;
import com.library.libraryapi.model.validation.exceptions.BadReservationDateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @PostMapping("/reservation")
    public ResponseEntity createReservation(@RequestBody ReservationDTO reservationDTO) {
        try {
            reservationService.createReservation(reservationDTO);
            return ResponseEntity.ok().build();
        } catch (BadReservationDateException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
        }
    }
}

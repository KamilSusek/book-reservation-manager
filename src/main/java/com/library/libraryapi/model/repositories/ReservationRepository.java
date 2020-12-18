package com.library.libraryapi.model.repositories;

import com.library.libraryapi.model.dao.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}

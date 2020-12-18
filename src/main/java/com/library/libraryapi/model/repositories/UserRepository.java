package com.library.libraryapi.model.repositories;

import com.library.libraryapi.model.dao.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> getUserByUsername(String username);
}

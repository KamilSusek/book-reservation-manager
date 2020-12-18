package com.library.libraryapi.model.services;

import com.library.libraryapi.model.dao.entities.User;
import com.library.libraryapi.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    public User createUser(String username) {
        final User user = userRepository.getUserByUsername(username).orElse(null);

        if (user != null) {
            return user;
        } else {
            final UUID uuid = UUID.randomUUID();
            final User saveUser = new User(uuid, username);
            userRepository.save(saveUser);
            return saveUser;
        }
    }
}

package com.fcs.userapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fcs.exception.UserNotFoundException;
import com.fcs.userapi.model.User;
import com.fcs.userapi.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserByEmail(final String email) {
        final var user = userRepository.getUserByEmail(email);
        if (user.isPresent()) {
            return user;
        }
        throw new UserNotFoundException(String.format("User with email %s not found", email));
    }

    public Optional<List<User>> getAll() {
        return Optional.of(userRepository.findAll());
    }

    public Optional<List<User>> findByName(final String name) {
        return userRepository.findByNameLike(name);
    }

    public Optional<User> findById(final long id) {
        return userRepository.findById(id);
    }

    public User save(final User user) {
        return userRepository.save(user);
    }

    public void delete(final long id) {
        userRepository.deleteById(id);
    }
}

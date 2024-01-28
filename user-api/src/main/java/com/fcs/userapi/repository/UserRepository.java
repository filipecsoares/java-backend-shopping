package com.fcs.userapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fcs.userapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByEmail(String email);

    Optional<List<User>> findByNameLike(String name);
}

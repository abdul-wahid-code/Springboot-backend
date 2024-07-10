package com.example.digital.workshop.repository;

import com.example.digital.workshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Userrepo extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}

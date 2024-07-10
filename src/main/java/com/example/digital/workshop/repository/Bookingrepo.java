package com.example.digital.workshop.repository;

import com.example.digital.workshop.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Bookingrepo extends JpaRepository<Booking,Long> {
}

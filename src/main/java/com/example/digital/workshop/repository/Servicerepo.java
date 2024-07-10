package com.example.digital.workshop.repository;

import com.example.digital.workshop.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Servicerepo extends JpaRepository<Service,Long> {
}

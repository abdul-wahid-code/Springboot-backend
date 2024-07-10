package com.example.digital.workshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Service {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Serviceid;
    private String type;
    private String description;

}

package com.example.digital.workshop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Bookingid;
    private LocalDate date;
    private LocalTime time;
    private String status;

    @ManyToOne
    @JoinColumn (name = "Userid")
    private User user;

    @ManyToOne
    @JoinColumn (name = "Serviceid" )
    private Service service;
}

package com.example.digital.workshop.controller;



import com.example.digital.workshop.model.Booking;
import com.example.digital.workshop.repository.Bookingrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
@CrossOrigin(origins = "http://localhost:3000/")
public class BookingController {

    @Autowired
    private Bookingrepo bookingrepo;

    // Create a new booking
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingrepo.save(booking);
    }

    // Get all bookings
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingrepo.findAll();
    }

    // Get a single booking by ID
    @GetMapping("/{Bookingid}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long Bookingid) {
        Optional<Booking> booking = bookingrepo.findById(Bookingid);
        if (booking.isPresent()) {
            return ResponseEntity.ok(booking.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update a booking
    @PutMapping("/{Bookingid}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long Bookingid, @RequestBody Booking bookingDetails) {
        Optional<Booking> bookingOptional = bookingrepo.findById(Bookingid);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            booking.setDate(bookingDetails.getDate());
            booking.setTime(bookingDetails.getTime());
            booking.setStatus(bookingDetails.getStatus());
            booking.setUser(bookingDetails.getUser());
            booking.setService(bookingDetails.getService());
            return ResponseEntity.ok(bookingrepo.save(booking));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a booking
    @DeleteMapping("/{Bookingid}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long Bookingid) {
        Optional<Booking> booking = bookingrepo.findById(Bookingid);
        if (booking.isPresent()) {
            bookingrepo.delete(booking.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

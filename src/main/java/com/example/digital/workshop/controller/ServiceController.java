package com.example.digital.workshop.controller;

import com.example.digital.workshop.model.Service;
import com.example.digital.workshop.repository.Servicerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/services")
@CrossOrigin(origins = "http://localhost:3000/")
public class ServiceController {

    @Autowired
    private Servicerepo servicerepo;

    // Create a new service
    @PostMapping
    public Service createService(@RequestBody Service service) {
        return servicerepo.save(service);
    }

    // Get all services
    @GetMapping
    public List<Service> getAllServices() {
        return servicerepo.findAll();
    }

    // Get a single service by ID
    @GetMapping("/{Serviceid}")
    public ResponseEntity<Service> getServiceById(@PathVariable Long Serviceid) {
        Optional<Service> service = servicerepo.findById(Serviceid);
        if (service.isPresent()) {
            return ResponseEntity.ok(service.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update a service
    @PutMapping("/{Serviceid}")
    public ResponseEntity<Service> updateService(@PathVariable Long Serviceid, @RequestBody Service serviceDetails) {
        Optional<Service> serviceOptional = servicerepo.findById(Serviceid);
        if (serviceOptional.isPresent()) {
            Service service = serviceOptional.get();
            service.setType(serviceDetails.getType());
            service.setDescription(serviceDetails.getDescription());
            return ResponseEntity.ok(servicerepo.save(service));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a service
    @DeleteMapping("/{Serviceid}")
    public ResponseEntity<Void> deleteService(@PathVariable Long Serviceid) {
        Optional<Service> service = servicerepo.findById(Serviceid);
        if (service.isPresent()) {
            servicerepo.delete(service.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.example.digital.workshop.controller;

import com.example.digital.workshop.dto.LoginRequest;
import com.example.digital.workshop.model.User;
import com.example.digital.workshop.repository.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000/")
public class Usercontroller {
    @Autowired
    private Userrepo userrepo;


    @GetMapping
    public List<User> getLLUser() {
        return userrepo.findAll();
    }


    @PostMapping("/save")
    public User saveuser(@RequestBody User user){
        return userrepo.save(user);
    }




    @PutMapping("/{Userid}")
    public User updateuser(@PathVariable Long Userid, @RequestBody User user){
        User users = userrepo.findById(Userid).orElseThrow(()-> new RuntimeException("User not found"));
        users.setName(user.getName());
        users.setEmail(user.getEmail());
        users.setPassword(user.getPassword());
        users.setPhone(user.getPhone());
        return userrepo.save(users);
    }


    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
        Optional<User> userOptional = userrepo.findByEmail(loginRequest.getEmail());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(loginRequest.getPassword())) {
                return ResponseEntity.ok().body("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }



}

package com.example.digital.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class DigitalWorkshopApplication {
	@RequestMapping("/")
	public String home(){
		return "Welcome";
	}
	public static void main(String[] args) {
		SpringApplication.run(DigitalWorkshopApplication.class, args);
	}

}

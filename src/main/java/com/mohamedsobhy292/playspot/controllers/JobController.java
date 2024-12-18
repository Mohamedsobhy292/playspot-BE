package com.mohamedsobhy292.playspot.controllers;

import com.mohamedsobhy292.playspot.services.VenueService;
import com.mohamedsobhy292.playspot.entities.Venue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class JobController {

    @Autowired
    private final VenueService venueService;

    public JobController(VenueService venueService) {
        this.venueService = venueService;
    }

    @PostMapping("/venues")
    ResponseEntity<?> saveVenue(@RequestBody Venue venue) {
        try {
            Venue savedVenue = venueService.saveVenue(venue);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedVenue);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/venues")
    ResponseEntity<?> getAllVenues() {
        try {
            List<Venue> venues = venueService.getAll();
            return ResponseEntity.status(HttpStatus.OK).body(venues);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

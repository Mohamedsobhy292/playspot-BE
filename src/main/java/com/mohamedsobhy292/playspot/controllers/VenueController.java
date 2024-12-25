package com.mohamedsobhy292.playspot.controllers;

import com.mohamedsobhy292.playspot.services.AddressService;
import com.mohamedsobhy292.playspot.services.VenueService;
import com.mohamedsobhy292.playspot.DTO.VenueDTO;

import com.mohamedsobhy292.playspot.entities.Venue;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/venues")

@CrossOrigin(origins = "http://localhost:3000")
public class VenueController {

    @Autowired
    private final VenueService venueService;

    public VenueController(VenueService venueService, AddressService addressService) {
        this.venueService = venueService;

    }

    @PostMapping()
    ResponseEntity<?> saveVenue(@RequestBody VenueDTO venue) {
        try {
            Venue savedVenue = venueService.save(venue);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedVenue);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<String, String>() {
                {
                    put("message", e.getMessage());
                }
            });
        }
    }

    @GetMapping()
    ResponseEntity<?> getAllVenues() {
        try {
            List<Venue> venues = venueService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(venues);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

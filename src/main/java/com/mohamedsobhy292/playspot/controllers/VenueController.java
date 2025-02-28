package com.mohamedsobhy292.playspot.controllers;

import com.mohamedsobhy292.playspot.services.AddressService;
import com.mohamedsobhy292.playspot.services.VenueService;
import com.mohamedsobhy292.playspot.services.projections.VenueResponseDTO;

import jakarta.validation.Valid;

import com.mohamedsobhy292.playspot.DTO.VenueDTO;

import com.mohamedsobhy292.playspot.entities.Venue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/venues")
public class VenueController {

    @Autowired
    private final VenueService venueService;

    public VenueController(VenueService venueService, AddressService addressService) {
        this.venueService = venueService;

    }

    @PostMapping()
    ResponseEntity<Venue> saveVenue(@Valid @RequestBody VenueDTO venue) {
        Venue savedVenue = venueService.addVenue(venue);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVenue);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getVenueById(@PathVariable Long id) {
        try {
            VenueResponseDTO venue = venueService.getVenueById(id);
            return ResponseEntity.status(HttpStatus.OK).body(venue);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping()
    ResponseEntity<?> getAllVenues(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Page<VenueResponseDTO> venues = venueService.getAllVenues(page, size);
            return ResponseEntity.status(HttpStatus.OK).body(venues);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

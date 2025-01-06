package com.mohamedsobhy292.playspot.controllers;

import com.mohamedsobhy292.playspot.services.CourtService;

import jakarta.validation.Valid;

import com.mohamedsobhy292.playspot.DTO.CourtDTO;
import com.mohamedsobhy292.playspot.entities.Court;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/courts")
public class CourtController {

    @Autowired
    private final CourtService courtService;

    public CourtController(CourtService courtService) {
        this.courtService = courtService;
    }

    @PostMapping()
    ResponseEntity<?> save(@Valid @RequestBody CourtDTO courtDTO) {
        Court savedCourt = courtService.addCourt(courtDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCourt);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getAll(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(courtService.getAllCourtsForVenue(id));
    }
}

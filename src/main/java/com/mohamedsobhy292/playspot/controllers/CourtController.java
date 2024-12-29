package com.mohamedsobhy292.playspot.controllers;

import com.mohamedsobhy292.playspot.services.CourtService;
import com.mohamedsobhy292.playspot.DTO.CourtDTO;
import com.mohamedsobhy292.playspot.entities.Court;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    ResponseEntity<?> save(@RequestBody CourtDTO courtDTO) {
        try {
            Court savedCourt = courtService.save(courtDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCourt);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<String, String>() {
                {
                    put("message", e.getMessage());
                }
            });
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getAll(@PathVariable String id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(courtService.findAll(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

package com.mohamedsobhy292.playspot.controllers;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohamedsobhy292.playspot.DTO.OpeningHoursDTO;
import com.mohamedsobhy292.playspot.entities.OpeningHours;
import com.mohamedsobhy292.playspot.services.OpeningHoursService;

@RestController()
@RequestMapping("/opening-hours")
public class OpeningHoursController {
    private final OpeningHoursService OpeningHoursService;

    public OpeningHoursController(OpeningHoursService OpeningHoursService) {
        this.OpeningHoursService = OpeningHoursService;
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody OpeningHoursDTO openingHoursDTO) {
        try {
            OpeningHours savedEntity = OpeningHoursService.save(openingHoursDTO);
            return ResponseEntity.status(HttpStatus.OK).body(savedEntity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<String, String>() {
                {
                    put("message", e.getMessage());
                }
            });
        }
    }

}

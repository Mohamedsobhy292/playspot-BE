package com.mohamedsobhy292.playspot.controllers;

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
    public OpeningHours save(@RequestBody OpeningHoursDTO openingHoursDTO) {
        try {
            return OpeningHoursService.save(openingHoursDTO);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}

package com.mohamedsobhy292.playspot.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    ResponseEntity<String> getMain() {
        return ResponseEntity.status(HttpStatus.OK).body("MIDO");
    }
}

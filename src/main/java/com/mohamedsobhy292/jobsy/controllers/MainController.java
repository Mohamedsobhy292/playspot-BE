package com.mohamedsobhy292.jobsy.controllers;


import com.mohamedsobhy292.jobsy.entities.Company;
import com.mohamedsobhy292.jobsy.entities.Job;
import com.mohamedsobhy292.jobsy.entities.JobType;
import com.mohamedsobhy292.jobsy.services.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class MainController {
    
    @GetMapping("/")
    ResponseEntity<String> getMain() {
        return ResponseEntity.status(HttpStatus.OK).body("MIDO");
    }
}

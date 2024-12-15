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

    private final JobService jobService;

    public MainController(JobService jobService) {
        this.jobService = jobService;
    }


    @GetMapping("/")
    ResponseEntity<?> getMain() {

        try {
            Job jobToSave = new Job();
            jobToSave.setCity("shebiin");
            jobToSave.setDescription("description");
            jobToSave.setTitle("job title");
            jobToSave.setType(JobType.valueOf("PART_TIME"));
            Company company = new Company();
            company.setName("name");
            company.setId(1L);
            company.setAddress("address");
            jobToSave.setCompany(company);
            Job res = jobService.saveJob(jobToSave);
            return ResponseEntity.status(HttpStatus.OK).body(res);

        } catch (Exception e) {
            HashMap<String, String> returnValue = new HashMap<String, String>();
            returnValue.put("mido", "message");
            returnValue.put("message", e.getMessage());


            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(returnValue);
        }


    }
}

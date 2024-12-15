package com.mohamedsobhy292.jobsy.entities;

import jakarta.persistence.*;

@Entity(name = "ApplicationStatus")
public class ApplicationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;
    
}

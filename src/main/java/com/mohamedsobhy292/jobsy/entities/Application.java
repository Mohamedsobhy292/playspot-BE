package com.mohamedsobhy292.jobsy.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Job job;

    @OneToMany()
    @JoinColumn(nullable = false)
    private List<ApplicationStatus> applicationStatus;

}

package com.mohamedsobhy292.jobsy.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @Column(unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Job job;


    @ManyToOne()
    @JoinColumn(nullable = false)
    @ColumnDefault("1")
    private ApplicationStatus applicationStatus;

}

package com.mohamedsobhy292.jobsy.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @ColumnDefault("'FULL_TIME'")
    private JobType type = JobType.FULL_TIME;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Company company;

    @ManyToMany(mappedBy = "job")
    private List<Skill> skill;
}

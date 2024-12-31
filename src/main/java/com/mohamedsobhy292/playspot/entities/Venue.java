package com.mohamedsobhy292.playspot.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "Venue")
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, columnDefinition = "serial")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String city;

    @OneToOne()
    @JoinColumn(name = "address_id")
    private Address address;

    private String description;

    @OneToMany(mappedBy = "venue", fetch = FetchType.LAZY)
    private List<Court> courts = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

}

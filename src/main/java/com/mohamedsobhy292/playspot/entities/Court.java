package com.mohamedsobhy292.playspot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Court")
public class Court extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Venue venue;

    @ManyToOne()
    @JoinColumn(nullable = false, name = "court_type_id")
    private CourtType courtType;

    @OneToOne(optional = true, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(nullable = true, name = "opening_hours_id")
    private OpeningHours openingHours;

}

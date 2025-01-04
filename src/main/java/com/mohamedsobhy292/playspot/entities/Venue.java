package com.mohamedsobhy292.playspot.entities;

import java.util.ArrayList;
import java.util.List;

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
public class Venue extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @OneToOne()
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(length = 1000)
    private String description;

    @OneToMany(mappedBy = "venue", fetch = FetchType.LAZY)
    private List<Court> courts = new ArrayList<>();

}

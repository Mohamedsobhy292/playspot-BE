package com.mohamedsobhy292.playspot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CourtType")
public class CourtType extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

}

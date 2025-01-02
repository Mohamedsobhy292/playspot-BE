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
@Entity(name = "Booking")
public class Booking extends BaseEntity {

    private String name;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Venue venue;

    @ManyToOne()
    @JoinColumn(nullable = false)
    // @ColumnDefault("1")
    private BookingStatus bookingStatus;

}

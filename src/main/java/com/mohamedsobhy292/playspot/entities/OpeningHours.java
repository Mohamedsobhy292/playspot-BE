package com.mohamedsobhy292.playspot.entities;

import java.time.LocalTime;

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
@Entity(name = "OpeningHours")
public class OpeningHours extends BaseEntity {

    private LocalTime mondayOpeningTime;
    private LocalTime mondayClosingTime;

    private LocalTime tuesdayOpeningTime;
    private LocalTime tuesdayClosingTime;

    private LocalTime wednesdayOpeningTime;
    private LocalTime wednesdayClosingTime;

    private LocalTime thursdayOpeningTime;
    private LocalTime thursdayClosingTime;

    private LocalTime fridayOpeningTime;
    private LocalTime fridayClosingTime;

    private LocalTime saturdayOpeningTime;
    private LocalTime saturdayClosingTime;

    private LocalTime sundayOpeningTime;
    private LocalTime sundayClosingTime;

}

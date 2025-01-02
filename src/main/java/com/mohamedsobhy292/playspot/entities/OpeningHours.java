package com.mohamedsobhy292.playspot.entities;

import java.time.ZonedDateTime;

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

    private ZonedDateTime mondayOpeningTime;
    private ZonedDateTime mondayClosingTime;

    private ZonedDateTime tuesdayOpeningTime;
    private ZonedDateTime tuesdayClosingTime;

    private ZonedDateTime wednesdayOpeningTime;
    private ZonedDateTime wednesdayClosingTime;

    private ZonedDateTime thursdayOpeningTime;
    private ZonedDateTime thursdayClosingTime;

    private ZonedDateTime fridayOpeningTime;
    private ZonedDateTime fridayClosingTime;

    private ZonedDateTime saturdayOpeningTime;
    private ZonedDateTime saturdayClosingTime;

    private ZonedDateTime sundayOpeningTime;
    private ZonedDateTime sundayClosingTime;

    @OneToOne(mappedBy = "openingHours")
    private Court court;

}

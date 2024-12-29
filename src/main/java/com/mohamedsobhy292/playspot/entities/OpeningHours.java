package com.mohamedsobhy292.playspot.entities;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
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
public class OpeningHours {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false, columnDefinition = "serial")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    Court court;

    private ZonedDateTime mondayOpeningTime;
    private LocalDateTime mondayClosingTime;

    private LocalDateTime tuesdayOpeningTime;
    private LocalDateTime tuesdayClosingTime;

    private LocalDateTime wednesdayOpeningTime;
    private LocalDateTime wednesdayClosingTime;

    private LocalDateTime thursdayOpeningTime;
    private LocalDateTime thursdayClosingTime;

    private LocalDateTime fridayOpeningTime;
    private LocalDateTime fridayClosingTime;

    private LocalDateTime saturdayOpeningTime;
    private LocalDateTime saturdayClosingTime;

    private LocalDateTime sundayOpeningTime;
    private LocalDateTime sundayClosingTime;

}

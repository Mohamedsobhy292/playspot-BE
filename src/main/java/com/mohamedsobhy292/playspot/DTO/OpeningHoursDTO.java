package com.mohamedsobhy292.playspot.DTO;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpeningHoursDTO {
    private Long id;
    private Long court_id;
    private String mondayOpeningTime;
    private LocalDateTime mondayClosingTime;
    private LocalDateTime tuesdayOpeningTime;
    private LocalDateTime tuesdayClosingTime;
    private LocalDateTime wednesdayOpeningTime;
    private LocalDateTime wednesdayClosingTime;
}

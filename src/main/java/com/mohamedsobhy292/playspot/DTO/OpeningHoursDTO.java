package com.mohamedsobhy292.playspot.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpeningHoursDTO {
    private Long id;
    private Long court_id;

    private String mondayOpeningTime;
    private String tuesdayOpeningTime;
    private String wednesdayOpeningTime;
    private String thursdayOpeningTime;
    private String fridayOpeningTime;
    private String saturdayOpeningTime;
    private String sundayOpeningTime;

    private String mondayClosingTime;
    private String tuesdayClosingTime;
    private String wednesdayClosingTime;
    private String thursdayClosingTime;
    private String fridayClosingTime;
    private String saturdayClosingTime;
    private String sundayClosingTime;

}

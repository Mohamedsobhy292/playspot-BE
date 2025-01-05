package com.mohamedsobhy292.playspot.DTO;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourtDTO {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Address id is mandatory")
    private String venue_id;
    @NotBlank(message = "Court type id is mandatory")
    private String court_type_id;
}

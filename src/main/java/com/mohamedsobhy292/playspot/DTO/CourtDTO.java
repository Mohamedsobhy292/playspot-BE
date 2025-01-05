package com.mohamedsobhy292.playspot.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourtDTO {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Address id is mandatory")
    private Long venue_id;

    @NotNull(message = "Court type id is mandatory")
    private Long court_type_id;
}

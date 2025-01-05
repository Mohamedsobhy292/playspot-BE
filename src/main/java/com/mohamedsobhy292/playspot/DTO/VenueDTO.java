package com.mohamedsobhy292.playspot.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VenueDTO {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Address is mandatory")
    private Long address_id;

    private String description;
}

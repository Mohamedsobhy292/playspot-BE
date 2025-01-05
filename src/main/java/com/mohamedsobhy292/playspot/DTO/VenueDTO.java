package com.mohamedsobhy292.playspot.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VenueDTO {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;
    private String city;
    @NotBlank(message = "Address is mandatory")
    private String address_id;

    private String description;
}

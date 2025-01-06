package com.mohamedsobhy292.playspot.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String street;

    @NotBlank(message = "zip code  is mandatory")
    private String zipCode;

    @NotNull(message = "city id is mandatory")
    private Long cityId;
}

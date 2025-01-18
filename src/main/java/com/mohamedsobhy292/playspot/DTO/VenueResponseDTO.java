package com.mohamedsobhy292.playspot.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VenueResponseDTO {
    private Long venueId;
    private String name;
    private String description;
    private AddressResponseDTO address;

    public VenueResponseDTO(Long venueId, String name, String description, String street, String zipCode,
            Long addressId, String city) {
        this.venueId = venueId;
        this.name = name;
        this.description = description;
        this.address = new AddressResponseDTO(street, zipCode, addressId, city);
    }

    @Getter
    @Setter
    public static class AddressResponseDTO {
        private String street;
        private String zipCode;
        private Long addressId;
        private String city;

        public AddressResponseDTO(String street, String zipCode, Long addressId, String city) {
            this.street = street;
            this.zipCode = zipCode;
            this.addressId = addressId;
            this.city = city;
        }

    }
}

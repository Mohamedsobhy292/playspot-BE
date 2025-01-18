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

    public VenueResponseDTO(
            Long venueId,
            String name,
            String description,
            String street,
            String zipCode,
            Long addressId,
            String city,
            String country,
            String countryCode) {
        this.venueId = venueId;
        this.name = name;
        this.description = description;
        this.address = new AddressResponseDTO(street, zipCode, addressId, city, country, countryCode);
    }

    @Getter
    @Setter
    public static class AddressResponseDTO {
        private String street;
        private String zipCode;
        private Long id;
        private String city;
        private String country;
        private String country_code;

        public AddressResponseDTO(String street, String zipCode, Long addressId, String city, String country,
                String country_code) {
            this.id = addressId;
            this.street = street;
            this.zipCode = zipCode;
            this.city = city;
            this.country = country;
            this.country_code = country_code;
        }

    }
}

package com.mohamedsobhy292.playspot.services.projections;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VenueResponseDTO {
    private Long venueId;
    private String name;
    private String description;
    private AddressResponseDTO address;
    private Long courtId;
    private String courtName;
    private List<Map<String, Object>> courts;
    private Long openingHoursId;

    public VenueResponseDTO(
            Long venueId,
            String name,
            String description,
            String street,
            String zipCode,
            Long addressId,
            String city,
            String country,
            String countryCode,
            Long courtId,
            String courtName,
            Long openingHoursId) {
        this.venueId = venueId;
        this.name = name;
        this.description = description;
        this.address = new AddressResponseDTO(street, zipCode, addressId, city, country, countryCode);
        this.courtId = courtId;
        this.courtName = courtName;
        this.openingHoursId = openingHoursId;

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

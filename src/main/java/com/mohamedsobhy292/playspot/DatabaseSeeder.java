package com.mohamedsobhy292.playspot;

import com.github.javafaker.Faker;
import com.mohamedsobhy292.playspot.entities.Address;
import com.mohamedsobhy292.playspot.entities.City;
import com.mohamedsobhy292.playspot.entities.Country;
import com.mohamedsobhy292.playspot.entities.Court;
import com.mohamedsobhy292.playspot.entities.CourtType;
import com.mohamedsobhy292.playspot.entities.OpeningHours;
import com.mohamedsobhy292.playspot.entities.Venue;
import com.mohamedsobhy292.playspot.repositories.AddressRepository;
import com.mohamedsobhy292.playspot.repositories.CityRepository;
import com.mohamedsobhy292.playspot.repositories.CountryRepository;
import com.mohamedsobhy292.playspot.repositories.CourtRepository;
import com.mohamedsobhy292.playspot.repositories.CourtTypeRepository;
import com.mohamedsobhy292.playspot.repositories.VenueRepository;

import java.util.List;
import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final AddressRepository addressRepository;
    private final VenueRepository venueRepository;
    private final CourtTypeRepository courtTypeRepository;
    private final CourtRepository courtRepository;

    DatabaseSeeder(
            CountryRepository countryRepository,
            CityRepository cityRepository,
            AddressRepository addressRepository,
            VenueRepository venueRepository,
            CourtTypeRepository courtTypeRepository,
            CourtRepository courtRepository) {
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
        this.addressRepository = addressRepository;
        this.venueRepository = venueRepository;
        this.courtTypeRepository = courtTypeRepository;
        this.courtRepository = courtRepository;
    }

    @Override
    public void run(String... args) {
        int max = 5;
        Faker faker = new Faker();

        List<CourtType> courtTypes = new ArrayList<>();
        List<Country> countries = new ArrayList<>();
        List<City> cities = new ArrayList<>();
        List<Address> addresses = new ArrayList<>();
        List<Venue> venues = new ArrayList<>();
        List<Court> courts = new ArrayList<>();

        // COURT TYPES
        courtTypes.add(new CourtType("PADEL"));
        courtTypes.add(new CourtType("TENNIS"));
        courtTypes.add(new CourtType("FOOTBALL"));

        // COUNTRIES

        countries.add(new Country("Germany", "DE"));
        countries.add(new Country("Spain", "ES"));
        countries.add(new Country("France", "FR"));

        // CITIES

        for (int j = 0; j < max * 2; j++) {
            City city = new City();
            city.setName(faker.address().city());
            city.setCountry(countries.get(faker.number().numberBetween(0, countries.size())));
            cities.add(city);

            // ADDRESSES

            for (int k = 0; k < max; k++) {
                Address address = new Address(
                        faker.address().streetAddress(), faker.address().zipCode(),
                        city);
                addresses.add(address);

                // VENUES

                // Venue venue = new Venue(
                // faker.company().name(),
                // address,
                // faker.lorem().paragraph(),
                // new ArrayList<>());
                // venues.add(venue);

                // for (int l = 0; l < max; l++) {
                // Court court = new Court();
                // court.setName(faker.company().name());
                // court.setVenue(venue);
                // court.setCourtType(courtTypes.get(faker.number().numberBetween(0,
                // courtTypes.size())));
                // courts.add(court);

                // }

            }
        }

        courtTypeRepository.saveAll(courtTypes);
        countryRepository.saveAll(countries);
        cityRepository.saveAll(cities);
        addressRepository.saveAll(addresses);
        venueRepository.saveAll(venues);
        courtRepository.saveAll(courts);

        System.out.println("Database initialized!");

    }
}

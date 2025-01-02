package com.mohamedsobhy292.playspot;

import com.github.javafaker.Faker;
import com.mohamedsobhy292.playspot.entities.Address;
import com.mohamedsobhy292.playspot.entities.City;
import com.mohamedsobhy292.playspot.entities.Country;
import com.mohamedsobhy292.playspot.repositories.AddressRepository;
import com.mohamedsobhy292.playspot.repositories.CityRepository;
import com.mohamedsobhy292.playspot.repositories.CountryRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final AddressRepository addressRepository;

    DatabaseSeeder(CountryRepository countryRepository, CityRepository cityRepository,
            AddressRepository addressRepository) {
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
        this.addressRepository = addressRepository;

    }

    @Override
    public void run(String... args) {

        int max = 5;
        Faker faker = new Faker();

        for (int i = 0; i < max; i++) {

            Country country = new Country(faker.country().name(), faker.country().countryCode2());
            countryRepository.save(country);

            for (int j = 0; j < max; j++) {
                City city = new City();
                city.setName(faker.address().city());
                city.setCountry(country);
                cityRepository.save(city);

                for (int k = 0; k < max; k++) {
                    Address address = new Address(
                            faker.address().streetAddress(), faker.address().zipCode(),
                            city);

                    address.setCity(city);
                    addressRepository.save(address);
                }

            }

        }

        System.out.println("Database initialized!");

    }
}

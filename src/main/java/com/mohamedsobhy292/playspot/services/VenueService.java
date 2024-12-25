package com.mohamedsobhy292.playspot.services;

import com.mohamedsobhy292.playspot.DTO.VenueDTO;
import com.mohamedsobhy292.playspot.entities.Address;
import com.mohamedsobhy292.playspot.entities.Venue;
import com.mohamedsobhy292.playspot.repositories.AddressRepository;
import com.mohamedsobhy292.playspot.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService {
    private final VenueRepository venueRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public VenueService(VenueRepository venueRepository, AddressRepository addressRepository) {
        this.venueRepository = venueRepository;
        this.addressRepository = addressRepository;
    }

    public Venue save(VenueDTO venue) {
        Optional<Address> address = addressRepository.findById(Long.parseLong(venue.getAddress_id()));
        System.out.println(venue.getAddress_id());
        System.out.println(address);

        Venue newVenue = new Venue();
        newVenue.setName(venue.getName());
        newVenue.setCity(venue.getCity());
        newVenue.setAddress(address.get());
        newVenue.setDescription(venue.getDescription());

        return venueRepository.save(newVenue);
    }

    public List<Venue> findAll() {
        return venueRepository.findAll();
    }

}

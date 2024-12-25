package com.mohamedsobhy292.playspot.services;

import com.mohamedsobhy292.playspot.DTO.VenueDTO;
import com.mohamedsobhy292.playspot.entities.Address;
import com.mohamedsobhy292.playspot.entities.Venue;
import com.mohamedsobhy292.playspot.repositories.AddressRepository;
import com.mohamedsobhy292.playspot.repositories.VenueRepository;

import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;

    public Venue save(VenueDTO venue) {
        Optional<Address> address = addressRepository.findById(Long.parseLong(venue.getAddress_id()));

        Venue newVenue = modelMapper.map(venue, Venue.class);
        newVenue.setAddress(address.get());

        return venueRepository.save(newVenue);
    }

    public List<Venue> findAll() {
        return venueRepository.findAll();
    }

}

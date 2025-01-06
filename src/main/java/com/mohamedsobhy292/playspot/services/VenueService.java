package com.mohamedsobhy292.playspot.services;

import com.mohamedsobhy292.playspot.DTO.VenueDTO;
import com.mohamedsobhy292.playspot.entities.Address;
import com.mohamedsobhy292.playspot.entities.Venue;
import com.mohamedsobhy292.playspot.exceptions.BadRequestException;
import com.mohamedsobhy292.playspot.exceptions.ResourceNotFoundException;
import com.mohamedsobhy292.playspot.repositories.AddressRepository;
import com.mohamedsobhy292.playspot.repositories.VenueRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VenueService {
    private final VenueRepository venueRepository;
    private final AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    public VenueService(VenueRepository venueRepository, AddressRepository addressRepository) {
        this.venueRepository = venueRepository;
        this.addressRepository = addressRepository;
    }

    public Venue addVenue(VenueDTO venue) {

        Long addressId = venue.getAddress_id();

        Optional<Address> address = addressRepository.findById(addressId);

        if (address.isEmpty()) {
            throw new BadRequestException("Address not found");
        }

        Venue AlreadyExistVenue = venueRepository.findByName(venue.getName());
        Venue AlreadyExistAddress = venueRepository.findByAddressId(venue.getAddress_id());

        if (AlreadyExistVenue != null) {
            throw new BadRequestException("Venue already exists");
        }

        if (AlreadyExistAddress != null) {
            throw new BadRequestException("venue in the same address already exists");
        }

        Venue newVenue = modelMapper.map(venue, Venue.class);
        newVenue.setAddress(address.get());

        return venueRepository.save(newVenue);
    }

    public Page<Venue> getAllVenues(Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);

        return venueRepository.findAll(paging);
    }

    public Optional<Venue> getVenueById(Long id) {
        Optional<Venue> venue = venueRepository.findById(id);

        if (venue.isEmpty()) {
            throw new ResourceNotFoundException("Venue not found");
        }

        return venue;

    }

}

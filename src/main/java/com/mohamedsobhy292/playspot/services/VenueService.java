package com.mohamedsobhy292.playspot.services;

import com.mohamedsobhy292.playspot.DTO.VenueDTO;
import com.mohamedsobhy292.playspot.entities.Address;
import com.mohamedsobhy292.playspot.entities.Venue;
import com.mohamedsobhy292.playspot.repositories.AddressRepository;
import com.mohamedsobhy292.playspot.repositories.VenueRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService {
    private final VenueRepository venueRepository;
    private final AddressRepository addressRepository;

    public VenueService(VenueRepository venueRepository, AddressRepository addressRepository) {
        this.venueRepository = venueRepository;
        this.addressRepository = addressRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    public Venue save(VenueDTO venue) {
        if (venue.getAddress_id() == null) {
            throw new RuntimeException("Address ID is required");
        }
        Optional<Address> address = addressRepository.findById(Long.parseLong(venue.getAddress_id()));

        if (address.isEmpty()) {
            throw new RuntimeException("Address not found");
        }

        Venue newVenue = modelMapper.map(venue, Venue.class);
        newVenue.setAddress(address.get());

        return venueRepository.save(newVenue);
    }

    public Page<Venue> findAll(Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);

        return venueRepository.findAll(paging);
    }

    public Venue findById(Long id) {
        return venueRepository.findVenueById(id);
    }

}

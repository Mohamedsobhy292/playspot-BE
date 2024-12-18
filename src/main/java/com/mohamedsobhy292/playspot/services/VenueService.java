package com.mohamedsobhy292.playspot.services;

import com.mohamedsobhy292.playspot.entities.Venue;
import com.mohamedsobhy292.playspot.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService {
    private final VenueRepository venueRepository;

    @Autowired
    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    public Venue saveVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    public List<Venue> getAll() {
        return venueRepository.findAll();
    }

}

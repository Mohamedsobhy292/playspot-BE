package com.mohamedsobhy292.playspot.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mohamedsobhy292.playspot.entities.Court;
import com.mohamedsobhy292.playspot.repositories.CourtRepository;

@Service
public class CourtService {
    private final CourtRepository courtRepository;

    public CourtService(CourtRepository courtRepository) {
        this.courtRepository = courtRepository;
    }

    public List<Court> findAll(String venueId) {
        return courtRepository.findAllByVenueId(Long.parseLong(venueId));
    }

    public Court save(Court court) {
        return courtRepository.save(court);
    }

}

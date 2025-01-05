package com.mohamedsobhy292.playspot.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohamedsobhy292.playspot.DTO.CourtDTO;
import com.mohamedsobhy292.playspot.entities.Court;
import com.mohamedsobhy292.playspot.entities.CourtType;
import com.mohamedsobhy292.playspot.entities.Venue;
import com.mohamedsobhy292.playspot.exceptions.BadRequestException;
import com.mohamedsobhy292.playspot.exceptions.ResourceNotFoundException;
import com.mohamedsobhy292.playspot.repositories.CourtRepository;
import com.mohamedsobhy292.playspot.repositories.CourtTypeRepository;
import com.mohamedsobhy292.playspot.repositories.VenueRepository;

@Service
public class CourtService {
    private final CourtRepository courtRepository;
    private final VenueRepository venueRepository;
    private final CourtTypeRepository courtTypeRepository;

    public CourtService(CourtRepository courtRepository, VenueRepository venueRepository,
            CourtTypeRepository courtTypeRepository) {
        this.courtRepository = courtRepository;
        this.venueRepository = venueRepository;
        this.courtTypeRepository = courtTypeRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    public List<Court> findAll(String venueId) {

        venueRepository.findById(Long.parseLong(venueId))
                .orElseThrow(() -> new BadRequestException("Venue not found"));

        var courts = courtRepository.findAllByVenueId(Long.parseLong(venueId));

        return courts;

    }

    public Court save(CourtDTO courtDTO) {
        if (courtDTO.getVenue_id() == null) {
            throw new RuntimeException("Venue is required");
        }

        Long venueId = courtDTO.getVenue_id();
        Long courtTypeId = courtDTO.getCourt_type_id();

        Optional<Venue> venue = venueRepository.findById(venueId);
        Optional<CourtType> courtType = courtTypeRepository.findById(courtTypeId);

        if (venue.isEmpty()) {
            throw new RuntimeException("venue not found");
        }

        Court AlreadyExists = courtRepository.findByVenueIdAndName(venueId,
                courtDTO.getName());

        if (AlreadyExists != null) {
            throw new RuntimeException("Court with the same name already exists");
        }

        Court newCourt = modelMapper.map(courtDTO, Court.class);
        newCourt.setVenue(venue.get());
        newCourt.setCourtType(courtType.get());
        return courtRepository.save(newCourt);
    }

}

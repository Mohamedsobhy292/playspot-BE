package com.mohamedsobhy292.playspot.services;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohamedsobhy292.playspot.DTO.OpeningHoursDTO;
import com.mohamedsobhy292.playspot.entities.Court;
import com.mohamedsobhy292.playspot.entities.OpeningHours;
import com.mohamedsobhy292.playspot.repositories.CourtRepository;
import com.mohamedsobhy292.playspot.repositories.OpeningHoursRepository;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class OpeningHoursService {
    private final OpeningHoursRepository openingHoursRepository;
    private final CourtRepository courtRepository;

    public OpeningHoursService(OpeningHoursRepository openingHoursRepository, CourtRepository courtRepository) {
        this.openingHoursRepository = openingHoursRepository;
        this.courtRepository = courtRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    public OpeningHours save(OpeningHoursDTO openingHoursDTO) {

        if (openingHoursDTO.getCourt_id() == null) {
            throw new RuntimeException("Court ID is required");
        }

        Long court_id = openingHoursDTO.getCourt_id();

        Optional<Court> court = courtRepository.findById((court_id));

        if (court.isEmpty()) {
            throw new RuntimeException("court not found");
        }

        OpeningHours newOpeningHours = modelMapper.map(openingHoursDTO, OpeningHours.class);

        String mondayOpeningTime = openingHoursDTO.getMondayOpeningTime();
        ZonedDateTime date = ZonedDateTime.parse(mondayOpeningTime);

        ZonedDateTime utcDateTime = date.withZoneSameInstant(ZoneId.of("UTC"));

        newOpeningHours
                .setMondayOpeningTime(utcDateTime);

        newOpeningHours.setCourt(court.get());
        return openingHoursRepository.save(newOpeningHours);
    }

}

package com.mohamedsobhy292.playspot.repositories;

import com.mohamedsobhy292.playspot.entities.Court;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtRepository extends JpaRepository<Court, Long> {

    List<Court> findAllByVenueId(Long venueId);

    Court findByVenueIdAndName(Long venueId, String name);

}

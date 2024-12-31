package com.mohamedsobhy292.playspot.repositories;

import com.mohamedsobhy292.playspot.entities.Court;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourtRepository extends JpaRepository<Court, Long> {

    // List<Court> findAllByVenueId(Long venueId);

    @Query("SELECT C FROM Court C WHERE C.venue.id = ?1")
    List<Court> findAllByVenueId(Long venueId);

    Court findByVenueIdAndName(Long venueId, String name);

}

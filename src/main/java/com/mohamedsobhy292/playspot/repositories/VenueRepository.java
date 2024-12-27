package com.mohamedsobhy292.playspot.repositories;

import com.mohamedsobhy292.playspot.entities.Venue;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VenueRepository extends JpaRepository<Venue, Long> {
    Page<Venue> findAll(Pageable pageable);

    // @Query(value = "SELECT v,c FROM Venue v JOIN FETCH Court c ON v.id =
    // c.venue.id WHERE v.id = ?1")
    // Venue findVenueByIdWithCourts(Long id);

    Venue findVenueById(Long id);

}

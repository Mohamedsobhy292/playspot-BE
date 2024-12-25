package com.mohamedsobhy292.playspot.repositories;

import com.mohamedsobhy292.playspot.entities.Venue;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
    Page<Venue> findAll(Pageable pageable);
}

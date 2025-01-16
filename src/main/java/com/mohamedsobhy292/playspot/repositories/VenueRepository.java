package com.mohamedsobhy292.playspot.repositories;

import com.mohamedsobhy292.playspot.DTO.ResponseDTO;
import com.mohamedsobhy292.playspot.entities.Venue;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VenueRepository extends JpaRepository<Venue, Long> {
    Page<Venue> findAll(Pageable pageable);

    Venue findByName(String name);

    Venue findByAddressId(Long addressId);

    @Query("""
             SELECT v.name AS name
                , v.id AS id,
                v.description AS description
            FROM Venue v
            WHERE v.id = :id
                    """)
    ResponseDTO findVenueCustom(@Param("id") Long id);

}

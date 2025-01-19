package com.mohamedsobhy292.playspot.repositories;

import com.mohamedsobhy292.playspot.services.projections.VenueResponseDTO;
import com.mohamedsobhy292.playspot.entities.Venue;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VenueRepository extends JpaRepository<Venue, Long> {
    Page<VenueResponseDTO> findAllBy(Pageable pageable);

    Venue findByName(String name);

    Venue findByAddressId(Long addressId);

    @Query("""
                    SELECT new com.mohamedsobhy292.playspot.services.projections.VenueResponseDTO(
                     v.id,
                     v.name,
                     v.description,
                     a.street,
                     a.zipCode,
                     a.id,
                    c.name,
                    co.name,
                    co.code,
                    cou.id,
                    cou.name
                    )
                   FROM Venue v
                   LEFT JOIN Address a ON v.address.id = a.id
                   LEFT JOIN City c ON a.city.id = c.id
                   LEFT JOIN Country co ON c.country.id = co.id
                   LEFT JOIN Court cou ON v.id = cou.venue.id
                   WHERE v.id = :id
            """)
    List<VenueResponseDTO> findVenueCustom(@Param("id") Long id);

}

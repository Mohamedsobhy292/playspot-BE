package com.mohamedsobhy292.playspot.repositories;

import com.mohamedsobhy292.playspot.entities.Address;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional findById(Long venueId);

}

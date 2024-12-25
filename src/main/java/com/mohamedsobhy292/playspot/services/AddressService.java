package com.mohamedsobhy292.playspot.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mohamedsobhy292.playspot.entities.Address;
import com.mohamedsobhy292.playspot.repositories.AddressRepository;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Optional<Address> getAddressById(Long addressId) {
        return addressRepository.findById(addressId);

    }

}

package com.mohamedsobhy292.playspot.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohamedsobhy292.playspot.DTO.AddressDTO;
import com.mohamedsobhy292.playspot.entities.Address;
import com.mohamedsobhy292.playspot.entities.City;
import com.mohamedsobhy292.playspot.exceptions.ResourceNotFoundException;
import com.mohamedsobhy292.playspot.repositories.AddressRepository;
import com.mohamedsobhy292.playspot.repositories.CityRepository;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final CityRepository cityRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AddressService(AddressRepository addressRepository, CityRepository cityRepository) {
        this.addressRepository = addressRepository;
        this.cityRepository = cityRepository;
    }

    public Optional<Address> getAddressById(Long addressId) {
        Optional<Address> result = addressRepository.findById(addressId);

        if (result.isEmpty()) {
            throw new ResourceNotFoundException("Address not found");
        }

        return result;

    }

    public Address addAddress(AddressDTO addressDTO) {
        Address address = modelMapper.map(addressDTO, Address.class);
        Optional<City> city = cityRepository.findById(addressDTO.getCityId());

        System.out.println(city);

        if (city.isEmpty()) {
            throw new ResourceNotFoundException("City not found");
        }

        return addressRepository.save(address);
    }

}

package com.mohamedsobhy292.playspot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohamedsobhy292.playspot.DTO.AddressDTO;
import com.mohamedsobhy292.playspot.entities.Address;
import com.mohamedsobhy292.playspot.services.AddressService;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(addressService.getAddressById(id));
        } catch (Exception e) {
            throw new RuntimeException("Error in getting the entities");
        }
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid @RequestBody AddressDTO addressDTO) {

        Address savedEntity = addressService.addAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.OK).body(savedEntity);

    }

}

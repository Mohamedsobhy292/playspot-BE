package com.mohamedsobhy292.playspot.services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohamedsobhy292.playspot.DTO.OpeningHoursDTO;
import com.mohamedsobhy292.playspot.entities.Court;
import com.mohamedsobhy292.playspot.entities.OpeningHours;
import com.mohamedsobhy292.playspot.repositories.CourtRepository;
import com.mohamedsobhy292.playspot.repositories.OpeningHoursRepository;

import jakarta.transaction.Transactional;

import java.time.LocalTime;

@Service
public class OpeningHoursService {
    private final OpeningHoursRepository openingHoursRepository;
    private final CourtRepository courtRepository;

    public OpeningHoursService(OpeningHoursRepository openingHoursRepository, CourtRepository courtRepository) {
        this.openingHoursRepository = openingHoursRepository;
        this.courtRepository = courtRepository;
    }

    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private LocalTime parseTime(String dateString) {
        LocalTime time = LocalTime.parse(dateString);
        return time;
    }

    private OpeningHours convertOpeningAndClosingTimes(OpeningHours newOpeningHours, OpeningHoursDTO openingHoursDTO) {
        HashMap<String, String> timeFields = new HashMap<String, String>();

        if (timeFields == null || newOpeningHours == null) {
            throw new IllegalArgumentException("timeFields and newOpeningHours must not be null");
        }

        ArrayList<String> days = new ArrayList<>(Arrays.asList(
                "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"));

        // ITERATE OVER THE DAYS AND GET THE OPENING AND CLOSING TIMES
        for (String day : days) {
            String openGetterName = "get" + capitalize(day) + "OpeningTime";
            String closeGetterName = "get" + capitalize(day) + "ClosingTime";
            try {
                Method openGetterMethod = OpeningHoursDTO.class.getMethod(openGetterName);
                Method closeGetterMethod = OpeningHoursDTO.class.getMethod(closeGetterName);
                String openingTime = (String) openGetterMethod.invoke(openingHoursDTO);
                String closingTime = (String) closeGetterMethod.invoke(openingHoursDTO);
                timeFields.put(day + "OpeningTime", openingTime);
                timeFields.put(day + "ClosingTime", closingTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // ITERATE OVER THE TIME FIELDS AND SET THE OPENING AND CLOSING TIMES
        for (Map.Entry<String, String> entry : timeFields.entrySet()) {
            String fieldName = entry.getKey();
            String timeValue = entry.getValue();

            if (timeValue == null) {
                continue;
            }

            String setterName = "set" + capitalize(fieldName);

            try {
                Method setterMethod = OpeningHours.class.getMethod(setterName, LocalTime.class);
                setterMethod.invoke(newOpeningHours, parseTime(timeValue));

            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {
                throw new RuntimeException("Error setting the opening and closing times");
            }

        }
        return newOpeningHours;
    }

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public OpeningHours save(OpeningHoursDTO openingHoursDTO) {

        if (openingHoursDTO.getCourt_id() == null) {
            throw new RuntimeException("Court ID is required");
        }

        // map the DTO to the entity
        OpeningHours mappedOpeningHours = modelMapper.map(openingHoursDTO, OpeningHours.class);

        // convert the opening and closing times to UTC
        OpeningHours mappedOpeningHoursToSave = convertOpeningAndClosingTimes(mappedOpeningHours, openingHoursDTO);

        // save the opening hours
        OpeningHours savedEntity = openingHoursRepository.save(mappedOpeningHoursToSave);

        // should update the court with the opening hours
        Optional<Court> court = courtRepository.findById(openingHoursDTO.getCourt_id());
        if (court.isPresent()) {
            court.get().setOpeningHours(savedEntity);
            courtRepository.save(court.get());
        } else {
            throw new RuntimeException("Court not found");
        }

        return savedEntity;
    }

}

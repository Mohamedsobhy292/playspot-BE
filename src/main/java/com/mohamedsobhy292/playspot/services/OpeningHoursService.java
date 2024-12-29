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
import java.time.ZoneId;
import java.time.ZonedDateTime;

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

    private ZonedDateTime convertDateToUTC(String dateString) {
        ZonedDateTime date = ZonedDateTime.parse(dateString);
        ZonedDateTime utcDateTime = date.withZoneSameInstant(ZoneId.of("UTC"));
        return utcDateTime;
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
                e.printStackTrace(); // Handle potential reflection errors
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
                Method setterMethod = OpeningHours.class.getMethod(setterName, ZonedDateTime.class);
                setterMethod.invoke(newOpeningHours, convertDateToUTC(timeValue));

            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {

                e.printStackTrace();
            }

        }
        return newOpeningHours;
    }

    @Autowired
    private ModelMapper modelMapper;

    public OpeningHours save(OpeningHoursDTO openingHoursDTO) {

        if (openingHoursDTO.getCourt_id() == null) {
            throw new RuntimeException("Court ID is required");
        }

        Long court_id = openingHoursDTO.getCourt_id();

        Optional<Court> court = courtRepository.findById((court_id));

        if (court.isEmpty()) {
            throw new RuntimeException("court not found");
        }

        OpeningHours mappedOpeningHours = modelMapper.map(openingHoursDTO, OpeningHours.class);

        OpeningHours mappedOpeningHoursToSave = convertOpeningAndClosingTimes(mappedOpeningHours, openingHoursDTO);

        OpeningHours newOpeningHours = new OpeningHours();

        // Map<String, ZonedDateTime> parsedTimes = new HashMap<>();

        // HashMap<String, String> timeFields = new HashMap<String, String>();
        // timeFields.put("mondayOpeningTime", openingHoursDTO.getMondayOpeningTime());
        // timeFields.put("tuesdayOpeningTime",
        // openingHoursDTO.getTuesdayOpeningTime());
        // timeFields.put("wednesdayOpeningTime",
        // openingHoursDTO.getWednesdayOpeningTime());

        // ZonedDateTime mondayOpeningTime =
        // convertDateToUTC(openingHoursDTO.getMondayOpeningTime());

        // for (Map.Entry<String, String> entry : timeFields.entrySet()) {
        // String fieldName = entry.getKey();
        // String timeValue = entry.getValue();
        // System.out.println(fieldName);

        // if (timeValue == null) {
        // continue;
        // }

        // // ZonedDateTime parsDateTime = parsedTimes.put(fieldName,
        // // convertDateToUTC(timeValue));
        // String setterName = "set" + fieldName.substring(0, 1).toUpperCase() +
        // fieldName.substring(1);
        // System.out.println(setterName);
        // try {
        // Method setterMethod = OpeningHours.class.getMethod(setterName,
        // ZonedDateTime.class);
        // setterMethod.invoke(newOpeningHours, convertDateToUTC(timeValue));
        // } catch (NoSuchMethodException | SecurityException | IllegalAccessException |
        // IllegalArgumentException
        // | InvocationTargetException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        // }

        // newOpeningHours
        // .setMondayOpeningTime(mondayOpeningTime);

        mappedOpeningHoursToSave.setCourt(court.get());
        return openingHoursRepository.save(mappedOpeningHoursToSave);
    }

}

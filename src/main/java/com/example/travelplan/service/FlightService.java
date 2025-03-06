package com.example.travelplan.service;

import com.example.travelplan.model.Flight;
import com.example.travelplan.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
    public List<Flight> getFlightsByDestination(String destination) {
        return flightRepository.findByDestination(destination);
    }
    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }
    public List<Flight> getFlightsByDate(LocalDate date) {
        return flightRepository.findByDate(date);
    }
    public List<Flight> getFlightsByTime(LocalTime time) {
        return flightRepository.findByTime(time);
    }
    public List<Flight> getFlightsByPrice(double price) {
        return flightRepository.findByPriceLessThanEqual(price);
    }
    public List<Flight> filterFlights(String destination, LocalDate date, LocalTime time, double price) {
     if (destination != null && date != null && time != null && price > 0) {
         return flightRepository.findByDestinationAndDateAndTimeAndPriceLessThanEqual
                 (destination, date, time, price);
     } else if (destination != null && date != null) {
         return flightRepository.findByDestinationAndDate(destination, date);
     } else if (destination != null) {
         return flightRepository.findByDestination(destination);
     } else if (date != null) {
         return flightRepository.findByDate(date);
     } else if (time != null) {
         return flightRepository.findByTime(time);
     } else if (price > 0) {
         return flightRepository.findByPriceLessThanEqual(price);
     } else {
         return flightRepository.findAll();
     }
    }
}



package com.example.travelplan.service;

import com.example.travelplan.model.Flight;
import com.example.travelplan.repository.FlightRepository;
import org.springframework.stereotype.Service;

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
    public List<Flight> getFlightsByADestination(String destination) {
        return flightRepository.findByDestination(destination);
    }
    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }
}

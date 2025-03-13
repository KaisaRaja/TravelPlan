package com.example.travelplan.service;

import com.example.travelplan.model.Flight;
import com.example.travelplan.repository.FlightRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    public List<Flight> getFlightsByPrice(double price) {
        return flightRepository.findByPriceLessThanEqual(price);
    }
    public List<Flight> filterFlights(String destination, LocalDate date, Double price) {
        if (destination != null && date != null && price != null) {
            return flightRepository.findByDestinationAndDateAndPriceLessThanEqual
                    (destination, date, price);
        } else if (destination != null && date != null) {
            return flightRepository.findByDestinationAndDate(destination, date);
        } else if (destination != null && date != null && price != null) {
            return flightRepository.findByDestinationAndDateAndPriceLessThanEqual(destination, date, price);
        } else if (destination != null) {
            return flightRepository.findByDestination(destination);
        } else if (date != null) {
            return flightRepository.findByDate(date);
        } else if (price != null) {
            return flightRepository.findByPriceLessThanEqual(price);
        } else {
            return flightRepository.findAll();
        }
    }
    public Page<Flight> filterFlights(String destination, LocalDate date, Double price, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return flightRepository.findByDestinationContainingAndDateAndPriceLessThanEqual(
                destination == null ? "" : destination,  // Filters strictly on destination
                date,                                    // Filters strictly on exact date
                price == null ? Double.MAX_VALUE : price,
                pageable
        );
    }
}


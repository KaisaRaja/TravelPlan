package com.example.travelplan.controller;

import com.example.travelplan.model.Flight;
import com.example.travelplan.repository.FlightRepository;
import com.example.travelplan.service.FlightService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import java.util.List;

@RestController
@RequestMapping("/flights")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FlightController {
    private final FlightService flightService;
    private final FlightRepository flightRepository;

    public FlightController(FlightService flightService, FlightRepository flightRepository) {
        this.flightService = flightService;
        this.flightRepository = flightRepository;
    }

    @GetMapping("/all")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }
    @GetMapping("/destinations")
    public List<String> getAvailableDestinations() {
        return flightRepository.findDistinctDestinations();
    }
    @PostMapping("/add")
    public Flight addFlight(@RequestBody Flight flight) {
        return flightService.saveFlight(flight);
    }
    @GetMapping("/search")
    public Page<Flight> getFilteredFlights(
            @RequestParam(required = false) String destination,
            @RequestParam(required = false) LocalDate date,
            @RequestParam(required = false, defaultValue = "0") Double price,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
            return flightService.filterFlights(destination, date, price, page, size);
    }
}

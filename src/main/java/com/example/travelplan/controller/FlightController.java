package com.example.travelplan.controller;

import com.example.travelplan.model.Flight;
import com.example.travelplan.service.FlightService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }
    @GetMapping("/destination/{destination")
    public List<Flight> getFlightsByDestination(@PathVariable String destination) {
        return flightService.getFlightsByADestination(destination);
    }
    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        return flightService.saveFlight(flight);
    }
}

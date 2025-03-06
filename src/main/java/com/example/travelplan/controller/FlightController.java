package com.example.travelplan.controller;

import com.example.travelplan.model.Flight;
import com.example.travelplan.service.FlightService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
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
    @GetMapping("/destination/{destination}")
    public List<Flight> getFlightsByDestination(@PathVariable String destination) {
        return flightService.getFlightsByDestination(destination);
    }
    @PostMapping("/add")
    public Flight addFlight(@RequestBody Flight flight) {
        return flightService.saveFlight(flight);
    }
    @GetMapping("/search")
    public List<Flight> filterFlights(
            @RequestParam(required = false) String destination,
            @RequestParam(required = false) LocalDate date,
            @RequestParam(required = false) LocalTime time,
            @RequestParam(required = false, defaultValue = "0") Double price)  {
            return flightService.filterFlights(destination, date, time, price);
    }
}

package com.example.travelplan.repository;

import com.example.travelplan.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByDestinationAnd(String destination);

    List<Flight> findByDestination(String destination);
}

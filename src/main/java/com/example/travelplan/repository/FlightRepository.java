package com.example.travelplan.repository;

import com.example.travelplan.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
      List<Flight> findByDestination(String destination);
      List<Flight> findByDate(LocalDate date);
      List<Flight> findByTime(LocalTime time);
      List<Flight> findByPriceLessThanEqual(Double price);
      List<Flight> findByDestinationAndDate(String destination, LocalDate date);
      List<Flight> findByDateBetween(LocalDate start, LocalDate end);
      List<Flight> findByTimeBetween(LocalTime start, LocalTime end);
      List<Flight> findByDestinationAndDateAndTimeAndPriceLessThanEqual
              (String destination, LocalDate date, LocalTime time, Double price);
}

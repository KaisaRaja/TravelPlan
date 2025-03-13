package com.example.travelplan.repository;

import com.example.travelplan.model.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
      @Query("SELECT DISTINCT f.destination FROM Flight f")
      List<String> findDistinctDestinations();
      Page<Flight> findByDestinationContainingAndDateAndPriceLessThanEqual(
              String destination, LocalDate date, double price, Pageable pageable);
      Page<Flight> findByDestinationContainingAndPriceLessThanEqual(
              String destination, Double price, Pageable pageable);
      List<Flight> findByDestination(String destination);
      List<Flight> findByDate(LocalDate date);
      List<Flight> findByPriceLessThanEqual(Double price);
      List<Flight> findByDestinationAndDate(String destination, LocalDate date);
      List<Flight> findByDestinationAndDateAndPriceLessThanEqual(String destination, LocalDate date, Double price);
      @Query("SELECT f FROM Flight f WHERE " +
              "(:destination IS NULL OR f.destination LIKE %:destination%) AND " +
              "(:date IS NULL OR f.date = :date) AND " +
              "(:price IS NULL OR f.price <= :price)")
      Page<Flight> filterFlights(@Param("destination") String destination,
                                 @Param("date") LocalDate date,
                                 @Param("price") Double price,
                                 Pageable pageable);
}

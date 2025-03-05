package com.example.travelplan.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name ="flights")

public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destination;
    private LocalDate date;
    private LocalTime time;
    private double price;


    public Flight(String destination, LocalDate date, LocalTime time, double price) {
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.price = price;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getTime() { return time; }
    public void setTime(LocalTime time) { this.time = time; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

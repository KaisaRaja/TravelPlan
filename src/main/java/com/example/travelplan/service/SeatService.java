package com.example.travelplan.service;

import com.example.travelplan.model.Airplane;
import com.example.travelplan.model.Seat;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatService {
    private final Airplane airplane;

    public SeatService(Airplane airplane) {
        this.airplane = new Airplane();
    }

    public List<Seat> getAvailableSeats() {
        return airplane.getSeats().stream()
                .filter(seat -> !seat.isOccupied())
                .collect(Collectors.toList());
    }
    public List<Seat> recommendSeats(int passangers, boolean window, boolean extraLegroom,boolean nearExit) {
    List<Seat> availableSeats = getAvailableSeats();

    return availableSeats.stream()
            .filter(seat -> (!window || seat.isWindow()))
            .filter(seat -> (!extraLegroom || seat.isHasExtraLegroom()))
            .filter(seat -> (!nearExit || seat.isExitRow()))
            .limit(passangers)
            .collect(Collectors.toList());
    }
}

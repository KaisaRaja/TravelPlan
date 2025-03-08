package com.example.travelplan.controller;

import com.example.travelplan.model.Seat;
import com.example.travelplan.service.SeatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {
    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/available")
    public List<Seat> getAvailableSeats() {
        return seatService.getAvailableSeats();
    }
    @GetMapping("/recommend")
    public List<Seat> getRecommendedSeats(
            @RequestParam int passengers,
            @RequestParam(required = false, defaultValue = "false") boolean window,
            @RequestParam(required = false, defaultValue = "false") boolean extraLegroom,
            @RequestParam(required = false, defaultValue = "false") boolean nearExit
    ) {
        return seatService.recommendSeats(passengers, window, extraLegroom, nearExit);

    }
}

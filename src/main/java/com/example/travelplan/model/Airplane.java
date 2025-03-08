package com.example.travelplan.model;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Component
public class Airplane {
    private List<Seat> seats = new ArrayList<>();
    private Random random = new Random();

    public Airplane() {
        generateSeats();
        randomlyOccupySeats();
    }
    private void generateSeats() {
        Random random = new Random();
        char[] seatColumns = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (int row = 1; row <= 20; row++) {
            for (char column : seatColumns) {
                String seatNo = row + "" + column;
                boolean isOccupied = random.nextBoolean();
                boolean isWindow = (column == 'A' || column == 'F');
                boolean hasExtraLegroom = (row == 1 || row == 10);
                boolean isExitRow = (row == 10 || row == 20);

                seats.add(new Seat(seatNo, isOccupied, isWindow, hasExtraLegroom, isExitRow));
            }
        }
    }
    private void randomlyOccupySeats() {
        for (Seat seat : seats) {
            if (random.nextDouble() < 0.5) {
                seat.setOccupied(true);
            }
        }
    }
    public List<Seat> getSeats() {
        return seats;
    }
    public void printSeatingPlan() {
        for (Seat seat : seats) {
            System.out.println(seat);
        }
    }

}


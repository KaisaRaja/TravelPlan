package com.example.travelplan.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Airplane {
    private List<Seat> seats = new ArrayList<>();
    private Random random = new Random();

    public Airplane() {
        generateSeats();
        randomlyOccupySeats();
    }
    private void generateSeats() {
        char[] columns = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (int row = 0; row <= 20; row++) {
            for (char column : columns) {
                boolean isWindow = (column == 'A' || column == 'F');
                boolean hasExtraLegroom = (row == 1 || row == 10);
                boolean isExitRow = (row == 10 || row == 20);

                seats.add(new Seat(row, column, isWindow, hasExtraLegroom, isExitRow));
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


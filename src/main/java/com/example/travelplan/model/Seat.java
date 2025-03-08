package com.example.travelplan.model;

public class Seat {
    private String seatNo;
    private boolean occupied;
    private boolean isWindow;
    private boolean hasExtraLegroom;
    private boolean isExitRow;

    public Seat(String seatNo, boolean isOccupied, boolean isWindow, boolean hasExtraLegroom, boolean isExitRow) {
        this.seatNo = seatNo;
        this.occupied = false;
        this.isWindow = isWindow;
        this.hasExtraLegroom = hasExtraLegroom;
        this.isExitRow = isExitRow;
    }
    public String getSeatNo() { return seatNo; }
    public boolean isOccupied() {return occupied;}
    public boolean isWindow() {return isWindow;}
    public boolean isHasExtraLegroom() {return hasExtraLegroom;}
    public boolean isExitRow() {return isExitRow;}
    public void setOccupied(boolean occupied) { this.occupied = occupied;}

}

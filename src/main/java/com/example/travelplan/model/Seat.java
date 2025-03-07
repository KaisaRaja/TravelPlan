package com.example.travelplan.model;

public class Seat {
    private int row;
    private int column;
    private boolean occupied;
    private boolean isWindow;
    private boolean hasExtraLegroom;
    private boolean isExitRow;

    public Seat(int row, char column, boolean isWindow, boolean hasExtraLegroom, boolean isExitRow) {
        this.row = row;
        this.column = column;
        this.occupied = false;
        this.isWindow = isWindow;
        this.hasExtraLegroom = hasExtraLegroom;
        this.isExitRow = isExitRow;
    }

    public int getRow() {return row;}
    public int getColumn() {return column;}
    public boolean isOccupied() {return occupied;}
    public boolean isWindow() {return isWindow;}
    public boolean isHasExtraLegroom() {return hasExtraLegroom;}
    public boolean isExitRow() {return isExitRow;}
    public void setOccupied(boolean occupied) { this.occupied = occupied;}

}

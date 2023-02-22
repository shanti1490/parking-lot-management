package org.example.model;

import java.util.Date;

public class ParkingTicket {
    String ticketNumber;
    int spotNumber;
    Date entryDate;

    public ParkingTicket(){}

    public ParkingTicket(String ticketNumber, int spot, Date entryDate){
        this.ticketNumber = ticketNumber;
        this.spotNumber = spot;
        this.entryDate = entryDate;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public String toString() {
        return "ParkingTicket{" +
                "ticketNumber='" + ticketNumber + '\'' +
                ", spotNumber=" + spotNumber +
                ", entryDate=" + entryDate +
                '}';
    }
}

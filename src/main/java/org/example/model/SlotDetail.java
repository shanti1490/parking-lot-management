package org.example.model;

import java.util.Objects;

public class SlotDetail {
    String ticketNumber;
    int slotNumber;
    boolean available;

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SlotDetail that = (SlotDetail) o;
        return getSlotNumber() == that.getSlotNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSlotNumber());
    }
}

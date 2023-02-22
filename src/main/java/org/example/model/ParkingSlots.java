package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingSlots {

    String vehicleType;
    int totalSlots;

    // maintains list of available slots after parking and unparking
    List<SlotDetail> availableSlots;
    // maintains list of unavailable slots after parking and unparking
    List<SlotDetail> unavailableSlots;

    //int lastSlotAvailable;

    public ParkingSlots(){
        availableSlots = new ArrayList<>();
        unavailableSlots = new ArrayList<>();
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    /*public int getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(int availableSlots) {
        this.availableSlots = availableSlots;
    }

    public int getLastSlotAvailable() {
        return lastSlotAvailable;
    }

    public void setLastSlotAvailable(int lastSlotAvailable) {
        this.lastSlotAvailable = lastSlotAvailable;
    }*/

    public List<SlotDetail> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<SlotDetail> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public void addSlotToAvailableList(SlotDetail slot){
        this.availableSlots.add(slot);
    }

    public void addSlotToUnavailableList(SlotDetail slot){
        this.unavailableSlots.add(slot);
    }

    public void removeSlotFromAvailableList(SlotDetail slot){
        this.availableSlots.remove(slot);
    }

    public void removeSlotFromUnavailableList(SlotDetail slot){
        this.unavailableSlots.remove(slot);
    }

    public List<SlotDetail> getUnavailableSlots() {
        return unavailableSlots;
    }

    public SlotDetail getSlotFromAvailableList(){
        return this.availableSlots.get(0);
    }

    public void setUnavailableSlots(List<SlotDetail> unavailableSlots) {
        this.unavailableSlots = unavailableSlots;
    }
}

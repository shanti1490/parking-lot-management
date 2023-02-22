package org.example.model;

public class ParkingSlotSetupRequest {

    String vehicleType;
    int totalSlots;

    public ParkingSlotSetupRequest(String vehicleType, int totalSlots) {
        this.vehicleType = vehicleType;
        this.totalSlots = totalSlots;
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
}

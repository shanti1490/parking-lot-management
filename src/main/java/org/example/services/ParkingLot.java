package org.example.services;

import org.example.enums.VehicleTypes;
import org.example.exception.GeneralServiceException;
import org.example.exception.ParkingNotAvailableException;
import org.example.model.*;
import org.example.util.DateTimeUtility;

import java.util.*;

public class ParkingLot {

    Map<String, ParkingSlots> parkingSlotsForVehicleType;
    Map<String,List<ParkingTicket>> parkingTicketsIssued;
    Map<String, ParkingReceipt> parkingReceiptsGiven;
    FeeModel feeModel;

    /*
     Here we set up the Parking Lot details like vehicleType and slots and fee model
     List contains each entry for every vehicleType
     */
    public ParkingLot(List<ParkingSlotSetupRequest> parkingSlotsRequest, FeeModel feeModel){
        this.feeModel = feeModel;
        this.parkingSlotsForVehicleType = new HashMap<>();
        initialiseParkingLotData(parkingSlotsRequest);
        parkingTicketsIssued = new HashMap<>();
        parkingReceiptsGiven = new HashMap<>();
    }

    private void initialiseParkingLotData(List<ParkingSlotSetupRequest> parkingSlotsRequest) {
        parkingSlotsRequest.forEach(slot -> {
            ParkingSlots slots = new ParkingSlots();
            slots.setVehicleType(slot.getVehicleType());
            slots.setTotalSlots(slot.getTotalSlots());
            for (int i = 0; i< slot.getTotalSlots(); i++){
                SlotDetail newAvailableSlot = new SlotDetail();
                newAvailableSlot.setAvailable(true);
                newAvailableSlot.setSlotNumber(i+1);
                slots.addSlotToAvailableList(newAvailableSlot);
            }

            parkingSlotsForVehicleType.put(slot.getVehicleType(), slots);
        });
    }

    public ParkingTicket parking(String  vehicleType, String date) throws ParkingNotAvailableException {

        ParkingSlots slotsForVehicleType = parkingSlotsForVehicleType.get(vehicleType);
        if(slotsForVehicleType.getAvailableSlots().size() == 0){
            throw new ParkingNotAvailableException("No Parking Available");
        }

        Date parkingTime = DateTimeUtility.convertStringToDate(date);
        int totalTicketsIssued = totalTicketsIssuedForParking();
        String ticketNumber = "00"+(totalTicketsIssued+1);
        int allocatedSpot;
        ParkingTicket ticketGenerated;
        List<ParkingTicket> listOfTicketsIssued;

        if(parkingTicketsIssued.get(vehicleType) == null || parkingTicketsIssued.get(vehicleType).isEmpty()) {

            allocatedSpot = 1;
            ticketGenerated = new ParkingTicket(ticketNumber, 1, parkingTime);
            listOfTicketsIssued = new ArrayList<>(){{add(ticketGenerated);}};

        } else {
            ParkingSlots slots = parkingSlotsForVehicleType.get(vehicleType);
            SlotDetail availableSlot  = slots.getSlotFromAvailableList();
            allocatedSpot = availableSlot.getSlotNumber();

            ticketGenerated = new ParkingTicket();
            ticketGenerated.setTicketNumber(ticketNumber);
            ticketGenerated.setSpotNumber(availableSlot.getSlotNumber());
            ticketGenerated.setEntryDate(parkingTime);
            listOfTicketsIssued = parkingTicketsIssued.get(vehicleType);
            listOfTicketsIssued.add(ticketGenerated);
        }
        updateParkingSlotDetailWhileParking(vehicleType, allocatedSpot, ticketNumber);
        parkingTicketsIssued.put(vehicleType, listOfTicketsIssued);
        return ticketGenerated;
    }

    private void updateParkingSlotDetailWhileParking(String vehicleType, int allocatedSpot, String ticketNumber) {
        ParkingSlots slotsForVehicleType = parkingSlotsForVehicleType.get(vehicleType);
        List<SlotDetail> availableSlots = slotsForVehicleType.getAvailableSlots();
        SlotDetail allocatedSlot = availableSlots.stream().filter(slot -> slot.getSlotNumber() == allocatedSpot).findAny().get();
        slotsForVehicleType.removeSlotFromAvailableList(allocatedSlot);
        allocatedSlot.setTicketNumber(ticketNumber);
        allocatedSlot.setAvailable(false);
        slotsForVehicleType.addSlotToUnavailableList(allocatedSlot);
    }

    public ParkingReceipt unparking(String vehicleType, String ticketNumber, String date) {
        Date exitDate = DateTimeUtility.convertStringToDate(date);
        List<ParkingTicket> parkingTicketsForVehicleType = parkingTicketsIssued.get(vehicleType);
        Optional<ParkingTicket> parkingTicketForTicketNumber = parkingTicketsForVehicleType.stream().filter(ticket -> ticket.getTicketNumber().equals(ticketNumber)).findFirst();

        if(parkingTicketForTicketNumber.isPresent()){
            int totalTicketsIssued = totalReceiptsForParking();
            int receiptNumber = totalTicketsIssued+1;

            ParkingTicket parkingTicketDetails = parkingTicketForTicketNumber.get();
            ParkingReceipt receipt = new ParkingReceipt();
            receipt.setReceiptNumber("R-00"+receiptNumber);
            receipt.setEntryDate(parkingTicketDetails.getEntryDate());
            receipt.setExitDate(exitDate);

            if(parkingReceiptsGiven.get(ticketNumber) == null){
                int fees = 0;
                TimePeriod timePeriodOfParking = DateTimeUtility.getDifferenceBetweenTwoDates(receipt.getEntryDate(), receipt.getExitDate());
                if(vehicleType.equals(VehicleTypes.MOTORCYCLE_SCOOTER.name())){
                    fees =feeModel.calculateMotorcycleFee(timePeriodOfParking);
                } else if(vehicleType.equals(VehicleTypes.CARS_SUV.name())){
                    fees =feeModel.calculateCarFee(timePeriodOfParking);
                } else if(vehicleType.equals(VehicleTypes.BUS_TRUCK.name())){
                    fees =feeModel.calculateBusFee(timePeriodOfParking);
                }
                receipt.setFees(fees);
                parkingReceiptsGiven.put(ticketNumber, receipt);
                updateParkingSlotDetailWhileUnparking(vehicleType, ticketNumber);
            } else {
                throw new GeneralServiceException("Receipt already given for the given parking ticket");
            }
            return receipt;
        }
        else{
            return null;
        }

    }

    private void updateParkingSlotDetailWhileUnparking(String vehicleType, String ticketNumber) {
        ParkingSlots slotsForVehicleType = parkingSlotsForVehicleType.get(vehicleType);
        List<SlotDetail> unavailableSlots = slotsForVehicleType.getUnavailableSlots();
        SlotDetail allocatedSlot = unavailableSlots.stream().filter(slot -> slot.getTicketNumber().equals(ticketNumber)).findAny().get();
        allocatedSlot.setTicketNumber(null);
        allocatedSlot.setAvailable(true);
        slotsForVehicleType.removeSlotFromUnavailableList(allocatedSlot);
        slotsForVehicleType.addSlotToAvailableList(allocatedSlot);
    }

    private int totalTicketsIssuedForParking() {
        int count = 0;
        for (VehicleTypes vehicleType: VehicleTypes.values()){
           List<ParkingTicket> parkingTickets =  parkingTicketsIssued.get(vehicleType.name());
           if(parkingTickets != null && !parkingTickets.isEmpty()) {
               count = count+ parkingTickets.size();
           }
        }
        return count;
    }

    private int totalReceiptsForParking() {
        return parkingReceiptsGiven.values().size();
    }



}

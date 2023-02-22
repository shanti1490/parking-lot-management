package org.example.services;

import org.example.enums.VehicleTypes;
import org.example.exception.ParkingNotAvailableException;
import org.example.model.ParkingReceipt;
import org.example.model.ParkingSlotSetupRequest;
import org.example.model.ParkingTicket;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotTest {

    /*
     Motorcycle - 3
     Car/Suv - 2
     Bus/truck - 2
     */
    ParkingLot parkingLotMall;
    ParkingLot parkingLotStadium;
    ParkingLot parkingLotAirport;
    @Before
    public void setup(){
        setupMallParkingLot(VehicleTypes.MOTORCYCLE_SCOOTER.name(), 3, VehicleTypes.CARS_SUV.name(), 2, VehicleTypes.BUS_TRUCK.name(), 2);
        setupStadiumParkinglot(VehicleTypes.MOTORCYCLE_SCOOTER.name(), 6, VehicleTypes.CARS_SUV.name(), 5, VehicleTypes.BUS_TRUCK.name(), 4);
        setupAirportParkinglot(VehicleTypes.MOTORCYCLE_SCOOTER.name(), 7, VehicleTypes.CARS_SUV.name(), 4, VehicleTypes.BUS_TRUCK.name(), 3);
    }

    private void setupMallParkingLot(String vehicleType1, int capacity1, String vehicletype2, int capacity2, String vehicleType3, int capacity3) {
        ParkingSlotSetupRequest motorcycleSlots = new ParkingSlotSetupRequest(vehicleType1, capacity1);
        ParkingSlotSetupRequest carSlots = new ParkingSlotSetupRequest(vehicletype2, capacity2);
        ParkingSlotSetupRequest busesSlots = new ParkingSlotSetupRequest(vehicleType3, capacity3);

        List<ParkingSlotSetupRequest> parkingSlotsForMall = new ArrayList<>();
        parkingSlotsForMall.add(motorcycleSlots);
        parkingSlotsForMall.add(carSlots);
        parkingSlotsForMall.add(busesSlots);

        parkingLotMall = new ParkingLot(parkingSlotsForMall, new MallFeeModel());
    }
    private void setupStadiumParkinglot(String vehicleType1, int capacity1, String vehicletype2, int capacity2, String vehicleType3, int capacity3) {
        ParkingSlotSetupRequest motorcycleSlots = new ParkingSlotSetupRequest(vehicleType1, capacity1);
        ParkingSlotSetupRequest carSlots = new ParkingSlotSetupRequest(vehicletype2, capacity2);
        ParkingSlotSetupRequest busesSlots = new ParkingSlotSetupRequest(vehicleType3, capacity3);

        List<ParkingSlotSetupRequest> parkingSlotsForStadium = new ArrayList<>();
        parkingSlotsForStadium.add(motorcycleSlots);
        parkingSlotsForStadium.add(carSlots);
        parkingSlotsForStadium.add(busesSlots);

        parkingLotStadium = new ParkingLot(parkingSlotsForStadium, new StadiumFeeModel());
    }

    private void setupAirportParkinglot(String vehicleType1, int capacity1, String vehicletype2, int capacity2, String vehicleType3, int capacity3) {
        ParkingSlotSetupRequest motorcycleSlots = new ParkingSlotSetupRequest(vehicleType1, capacity1);
        ParkingSlotSetupRequest carSlots = new ParkingSlotSetupRequest(vehicletype2, capacity2);
        ParkingSlotSetupRequest busesSlots = new ParkingSlotSetupRequest(vehicleType3, capacity3);

        List<ParkingSlotSetupRequest> parkingSlotsForAirport = new ArrayList<>();
        parkingSlotsForAirport.add(motorcycleSlots);
        parkingSlotsForAirport.add(carSlots);
        parkingSlotsForAirport.add(busesSlots);

        parkingLotAirport = new ParkingLot(parkingSlotsForAirport, new AirportFeeModel());
    }

    @Test
    public void testParkingUnparkingForMallParkingLot(){

        try{
            ParkingTicket ticket1 = parkingLotMall.parking(VehicleTypes.MOTORCYCLE_SCOOTER.name(), "01-Jan-2022 09:30:07");
            System.out.println(ticket1);
            ParkingTicket ticket2 = parkingLotMall.parking(VehicleTypes.MOTORCYCLE_SCOOTER.name(), "01-Jan-2022 10:30:07");
            System.out.println(ticket2);
            ParkingTicket ticket3 = parkingLotMall.parking(VehicleTypes.MOTORCYCLE_SCOOTER.name(), "01-Jan-2022 11:30:07");
            System.out.println(ticket3);
            ParkingTicket ticket4 = parkingLotMall.parking(VehicleTypes.MOTORCYCLE_SCOOTER.name(), "01-Jan-2022 11:30:07");
            System.out.println(ticket4);
        } catch (ParkingNotAvailableException e){
            System.out.println(e.getMessage());
        }

        ParkingReceipt parkingReceipt1 = parkingLotMall.unparking(VehicleTypes.MOTORCYCLE_SCOOTER.name(), "002","01-Jan-2022 12:30:07");
        System.out.println(parkingReceipt1);
        ParkingTicket ticket5 = parkingLotMall.parking(VehicleTypes.MOTORCYCLE_SCOOTER.name(), "01-Jan-2022 13:00:07");
        System.out.println(ticket5);

        ParkingTicket ticket6 = parkingLotMall.parking(VehicleTypes.CARS_SUV.name(), "01-Jan-2022 09:30:07");
        System.out.println(ticket6);
        ParkingTicket ticket7 = parkingLotMall.parking(VehicleTypes.CARS_SUV.name(), "01-Jan-2022 10:30:07");
        System.out.println(ticket7);
        ParkingReceipt receipt2 = parkingLotMall.unparking(VehicleTypes.CARS_SUV.name(), "006","01-Jan-2022 16:31:07");
        System.out.println(receipt2);

        ParkingTicket ticket8 = parkingLotMall.parking(VehicleTypes.BUS_TRUCK.name(), "01-Jan-2022 18:30:07");
        System.out.println(ticket8);
        ParkingReceipt receipt3 = parkingLotMall.unparking(VehicleTypes.BUS_TRUCK.name(), "007","01-Jan-2022 20:29:07");
        System.out.println(receipt3);

    }

    @Test
    public void testParkingUnparkingForStadiumParkingLot(){

        try{
            ParkingTicket ticket1 = parkingLotStadium.parking(VehicleTypes.MOTORCYCLE_SCOOTER.name(), "01-Jan-2022 08:00:07");
            System.out.println(ticket1);
            ParkingTicket ticket2 = parkingLotStadium.parking(VehicleTypes.MOTORCYCLE_SCOOTER.name(), "01-Jan-2022 10:00:07");
            System.out.println(ticket2);

            ParkingReceipt parkingReceipt1 = parkingLotStadium.unparking(VehicleTypes.MOTORCYCLE_SCOOTER.name(), "002","01-Jan-2022 13:40:07");
            System.out.println(parkingReceipt1);
            ParkingReceipt parkingReceipt2 = parkingLotStadium.unparking(VehicleTypes.MOTORCYCLE_SCOOTER.name(), "001","01-Jan-2022 22:59:07");
            System.out.println(parkingReceipt2);

            ParkingTicket ticket3 = parkingLotStadium.parking(VehicleTypes.CARS_SUV.name(), "01-Jan-2022 08:00:07");
            System.out.println(ticket3);
            ParkingTicket ticket4 = parkingLotStadium.parking(VehicleTypes.CARS_SUV.name(), "01-Jan-2022 10:00:07");
            System.out.println(ticket4);

            ParkingReceipt parkingReceipt3 = parkingLotStadium.unparking(VehicleTypes.CARS_SUV.name(), "002","01-Jan-2022 19:30:07");
            System.out.println(parkingReceipt3);
            ParkingReceipt parkingReceipt4 = parkingLotStadium.unparking(VehicleTypes.CARS_SUV.name(), "001","01-Jan-2022 23:05:07");
            System.out.println(parkingReceipt4);
        } catch (ParkingNotAvailableException e){
            System.out.println(e.getMessage());
        }



    }

    @Test
    public void testParkingUnparkingForAirportParkingLot(){

        try{
            ParkingTicket ticket1 = parkingLotAirport.parking(VehicleTypes.MOTORCYCLE_SCOOTER.name(), "01-Jan-2022 08:00:07");
            System.out.println(ticket1);
            ParkingTicket ticket2 = parkingLotAirport.parking(VehicleTypes.MOTORCYCLE_SCOOTER.name(), "01-Jan-2022 09:00:07");
            System.out.println(ticket2);
            ParkingReceipt receipt1 = parkingLotAirport.unparking(VehicleTypes.MOTORCYCLE_SCOOTER.name(), "002","01-Jan-2022 09:55:07");
            System.out.println(receipt1);
            ParkingReceipt receipt2 = parkingLotAirport.unparking(VehicleTypes.MOTORCYCLE_SCOOTER.name(), "001","01-Jan-2022 22:59:07");
            System.out.println(receipt2);

        } catch (ParkingNotAvailableException e){
            System.out.println(e.getMessage());
        }

    }
}

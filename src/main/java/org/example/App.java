package org.example;

import org.example.enums.VehicleTypes;
import org.example.exception.GeneralServiceException;
import org.example.exception.ParkingNotAvailableException;
import org.example.model.ParkingReceipt;
import org.example.model.ParkingSlotSetupRequest;
import org.example.model.ParkingTicket;
import org.example.services.ParkingLot;
import org.example.services.MallFeeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<ParkingSlotSetupRequest> parkingSlotsRequest = new ArrayList<>();
        ParkingSlotSetupRequest motorcycleSlots = new ParkingSlotSetupRequest(VehicleTypes.MOTORCYCLE_SCOOTER.name(), 2);
        ParkingSlotSetupRequest carSlots = new ParkingSlotSetupRequest(VehicleTypes.CARS_SUV.name(), 0);
        ParkingSlotSetupRequest busesSlots = new ParkingSlotSetupRequest(VehicleTypes.BUS_TRUCK.name(), 0);
        parkingSlotsRequest.add(motorcycleSlots);
        parkingSlotsRequest.add(carSlots);
        parkingSlotsRequest.add(busesSlots);
        MallFeeModel feeModel = new MallFeeModel();
        try{
            ParkingLot parkingLot = new ParkingLot(parkingSlotsRequest, feeModel);
            ParkingTicket result1 = parkingLot.parking(VehicleTypes.MOTORCYCLE_SCOOTER.name(), "29-May-2022 14:04:07");
            System.out.println(result1);
            ParkingTicket result2 = parkingLot.parking(VehicleTypes.MOTORCYCLE_SCOOTER.name(), "29-May-2022 14:44:07");
            System.out.println(result2);
           /* ParkingTicket result3 = parkingLot.parking(VehicleTypes.MOTORCYCLE_SCOOTER.name(), "29-May-2022 14:56:07");
            System.out.println(result3);*/
            ParkingReceipt result4 = parkingLot.unparking(VehicleTypes.MOTORCYCLE_SCOOTER.name(), "002", "29-May-2022 15:40:07");
            System.out.println(result4);
        } catch (ParkingNotAvailableException e){
            System.out.println(e.getMessage());
        } catch (GeneralServiceException e){
            System.out.println(e.getMessage());
        }

    }
}

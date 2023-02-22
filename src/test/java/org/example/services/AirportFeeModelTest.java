package org.example.services;

import org.example.model.TimePeriod;
import org.junit.Assert;
import org.junit.Test;

public class AirportFeeModelTest {
    @Test
    public void testMotorCycleParkingFeeForAirportFeeModel(){
        TimePeriod timePeriod1 = new TimePeriod();
        timePeriod1.setDays(0);
        timePeriod1.setHours(0);
        timePeriod1.setMins(55);

        TimePeriod timePeriod2 = new TimePeriod();
        timePeriod2.setDays(0);
        timePeriod2.setHours(14);
        timePeriod2.setMins(59);

        TimePeriod timePeriod3 = new TimePeriod();
        timePeriod3.setDays(1);
        timePeriod3.setHours(12);
        timePeriod3.setMins(0);

        FeeModel feeModel = new AirportFeeModel();
        int fee1 = feeModel.calculateMotorcycleFee(timePeriod1);
        int fee2 = feeModel.calculateMotorcycleFee(timePeriod2);
        int fee3 = feeModel.calculateMotorcycleFee(timePeriod3);
        Assert.assertEquals(fee1, 0);
        Assert.assertEquals(fee2, 60);
        Assert.assertEquals(fee3, 160);
    }
    @Test
    public void testCarParkingFeeForAirportFeeModel(){
        TimePeriod timePeriod1 = new TimePeriod();
        timePeriod1.setDays(0);
        timePeriod1.setHours(0);
        timePeriod1.setMins(50);

        TimePeriod timePeriod2 = new TimePeriod();
        timePeriod2.setDays(0);
        timePeriod2.setHours(23);
        timePeriod2.setMins(59);

        TimePeriod timePeriod3 = new TimePeriod();
        timePeriod3.setDays(3);
        timePeriod3.setHours(1);
        timePeriod3.setMins(0);

        FeeModel feeModel = new AirportFeeModel();

        int fee1 = feeModel.calculateCarFee(timePeriod1);
        int fee2 = feeModel.calculateCarFee(timePeriod2);
        int fee3 = feeModel.calculateCarFee(timePeriod3);
        Assert.assertEquals(fee1, 60);
        Assert.assertEquals(fee2, 80);
        Assert.assertEquals(fee3, 400);
    }
    @Test
    public void testTruckParkingFeeForAirportFeeModel(){
        TimePeriod timePeriod = new TimePeriod();
        timePeriod.setDays(0);
        timePeriod.setHours(1);
        timePeriod.setMins(59);

        FeeModel feeModel = new AirportFeeModel();
        int fee = feeModel.calculateBusFee(timePeriod);
        Assert.assertEquals(fee, 0);
    }
}

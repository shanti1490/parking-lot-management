package org.example.services;


import org.example.model.TimePeriod;
import org.junit.Assert;
import org.junit.Test;

public class MallFeeModelTest{

    @Test
    public void testMotorCycleParkingFeeForMallFeeModel(){
        TimePeriod timePeriod = new TimePeriod();
        timePeriod.setDays(0);
        timePeriod.setHours(3);
        timePeriod.setMins(30);

        FeeModel feeModel = new MallFeeModel();
        int fee = feeModel.calculateMotorcycleFee(timePeriod);
        Assert.assertEquals(fee, 40);
    }

    @Test
    public void testCarParkingFeeForMallFeeModel(){
        TimePeriod timePeriod = new TimePeriod();
        timePeriod.setDays(0);
        timePeriod.setHours(6);
        timePeriod.setMins(1);

        FeeModel feeModel = new MallFeeModel();
        int fee = feeModel.calculateCarFee(timePeriod);
        Assert.assertEquals(fee, 140);
    }

    @Test
    public void testTruckParkingFeeForMallFeeModel(){
        TimePeriod timePeriod = new TimePeriod();
        timePeriod.setDays(0);
        timePeriod.setHours(1);
        timePeriod.setMins(59);

        FeeModel feeModel = new MallFeeModel();
        int fee = feeModel.calculateBusFee(timePeriod);
        Assert.assertEquals(fee, 100);
    }

}

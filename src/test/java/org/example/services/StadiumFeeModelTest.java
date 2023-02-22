package org.example.services;

import org.example.model.TimePeriod;
import org.junit.Assert;
import org.junit.Test;

public class StadiumFeeModelTest {
    @Test
    public void testMotorCycleParkingFeeForStadiumFeeModel(){
        TimePeriod timePeriod1 = new TimePeriod();
        timePeriod1.setDays(0);
        timePeriod1.setHours(3);
        timePeriod1.setMins(40);

        TimePeriod timePeriod2 = new TimePeriod();
        timePeriod2.setDays(0);
        timePeriod2.setHours(14);
        timePeriod2.setMins(59);

        FeeModel feeModel = new StadiumFeeModel();
        int fee1 = feeModel.calculateMotorcycleFee(timePeriod1);
        int fee2 = feeModel.calculateMotorcycleFee(timePeriod2);
        Assert.assertEquals(fee1, 30);
        Assert.assertEquals(fee2, 390);
    }
    @Test
    public void testCarParkingFeeForStadiumFeeModel(){
        TimePeriod timePeriod1 = new TimePeriod();
        timePeriod1.setDays(0);
        timePeriod1.setHours(11);
        timePeriod1.setMins(30);

        TimePeriod timePeriod2 = new TimePeriod();
        timePeriod2.setDays(0);
        timePeriod2.setHours(13);
        timePeriod2.setMins(5);

        FeeModel feeModel = new StadiumFeeModel();

        int fee1 = feeModel.calculateCarFee(timePeriod1);
        int fee2 = feeModel.calculateCarFee(timePeriod2);
        Assert.assertEquals(fee1, 180);
        Assert.assertEquals(fee2, 580);
    }
    @Test
    public void testTruckParkingFeeForStadiumFeeModel(){
        TimePeriod timePeriod = new TimePeriod();
        timePeriod.setDays(0);
        timePeriod.setHours(1);
        timePeriod.setMins(59);

        FeeModel feeModel = new StadiumFeeModel();
        int fee = feeModel.calculateBusFee(timePeriod);
        Assert.assertEquals(fee, 0);
    }
}

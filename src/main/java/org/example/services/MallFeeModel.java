package org.example.services;


import org.example.model.TimePeriod;

public class MallFeeModel implements FeeModel {

    public int calculateMotorcycleFee(TimePeriod timeOfPeriod) {
        int totalHours = timeOfPeriod.getDays() * 24 + timeOfPeriod.getHours() + (timeOfPeriod.getMins()/60)+1;
        return 10*totalHours;
    }

    public int calculateCarFee(TimePeriod timeOfPeriod) {
        int totalHours = timeOfPeriod.getDays() * 24 + timeOfPeriod.getHours() + (timeOfPeriod.getMins()/60)+1;
        return 20*totalHours;
    }

    public int calculateBusFee(TimePeriod timeOfPeriod) {
        int totalHours = timeOfPeriod.getDays() * 24 + timeOfPeriod.getHours() + (timeOfPeriod.getMins()/60)+1;
        return 50*totalHours;
    }
}

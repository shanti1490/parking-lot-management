package org.example.services;


import org.example.model.TimePeriod;

public class AirportFeeModel implements FeeModel{

    public int calculateMotorcycleFee(TimePeriod timeOfPeriod) {

        int totalHours = timeOfPeriod.getDays() * 24 + timeOfPeriod.getHours() ;
        int mins = timeOfPeriod.getMins();
        int fee = 0;
        if(totalHours < 1 && mins < 60){
            return 0;
        } else if(totalHours >= 1 && totalHours < 8 && mins < 60){
            fee = fee+40;
        } else if(totalHours >= 8 && totalHours < 24 && mins < 60){
            fee = fee+60;
        } if(totalHours >= 24) {
            int hours = timeOfPeriod.getHours();
            int days = hours>0?1:0;
            days += timeOfPeriod.getDays();
            fee = days * 80;
        }
        return fee;
    }

    public int calculateCarFee(TimePeriod timeOfPeriod) {
        int totalHours = timeOfPeriod.getDays() * 24 + timeOfPeriod.getHours();
        int mins = timeOfPeriod.getMins();
        int fee = 0;
        if(totalHours < 12 && mins < 60){
            fee = 60;
        } else if(totalHours >= 12 && totalHours < 24 && mins < 60){
            fee = fee+80;
        }  else if(totalHours >= 24) {
            int hours = timeOfPeriod.getHours();
            int days = hours>0?1:0;
            days += timeOfPeriod.getDays();
            fee = days * 100;
        }
        return fee;
    }

    public int calculateBusFee(TimePeriod timeOfPeriod) {
        return 0;
    }
}

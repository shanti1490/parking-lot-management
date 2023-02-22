package org.example.services;

import org.example.model.TimePeriod;

public class StadiumFeeModel implements FeeModel{

    public int calculateMotorcycleFee(TimePeriod timeOfPeriod) {

        int totalHours = timeOfPeriod.getDays() * 24 + timeOfPeriod.getHours();
        int mins = timeOfPeriod.getMins();
        int fee = 0;
        if(totalHours < 4 && mins < 60){
            fee = fee+30;
        } else if(totalHours >= 4 && totalHours < 12 && mins < 60 ){
            fee = fee+30+60;
        } else if(totalHours >= 12) {
            int roundOfHours = mins/60 +1;
            fee = fee+30+60+ ((totalHours-12)+roundOfHours)*100;
        }
        return fee;
    }

    public int calculateCarFee(TimePeriod timeOfPeriod) {
        int totalHours = timeOfPeriod.getDays() * 24 + timeOfPeriod.getHours() ;
        int mins = timeOfPeriod.getMins();
        int fee = 0;
        if(totalHours < 4 && mins < 60){
            fee = fee+60;
        } else if(totalHours > 4 && totalHours < 12 && mins < 60){
            fee = fee+60+120;
        } else if(totalHours >= 12) {
            int roundOfHours = mins/60 +1;
            fee = fee+60+120+ ((totalHours -12)+roundOfHours)*200;
        }
        return fee;
    }

    public int calculateBusFee(TimePeriod timeOfPeriod) {
        return 0;
    }
}

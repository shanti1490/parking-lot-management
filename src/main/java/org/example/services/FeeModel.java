package org.example.services;

import org.example.model.TimePeriod;

public interface FeeModel {

     int calculateCarFee(TimePeriod timeOfPeriod);
     int calculateMotorcycleFee(TimePeriod timeOfPeriod);
    int calculateBusFee(TimePeriod timeOfPeriod);
}

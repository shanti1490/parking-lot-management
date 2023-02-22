package org.example.util;

import org.example.model.TimePeriod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtility {

    public static TimePeriod getDifferenceBetweenTwoDates(Date startTime, Date endTime) {
        long diff = endTime.getTime() - startTime.getTime();
        long min = diff/(60*1000);
        long days = min/(60*24);
        min = min % (60*24);
        long hours = min/60;
        min = min%60;
        TimePeriod timePeriod = new TimePeriod();
        timePeriod.setDays((int)days);
        timePeriod.setHours((int) hours);
        timePeriod.setMins((int) min);

        return timePeriod;
    }

    public static Date convertStringToDate(String date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

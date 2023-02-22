package org.example.util;

import org.example.model.TimePeriod;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class DateTimeUtilityTest {

    @Test
    public void testTimeDifferenceBetweenTwoDates() {
        String entryTime = "29-May-2022 14:04:07";
        String exitTime = "29-May-2022 15:44:27";


        Date startTime = DateTimeUtility.convertStringToDate(entryTime);
        Date endTime = DateTimeUtility.convertStringToDate(exitTime);
        TimePeriod period = DateTimeUtility.getDifferenceBetweenTwoDates(startTime, endTime);

        Assert.assertEquals(period.getDays(), 0);
        Assert.assertEquals(period.getHours(), 1);
        Assert.assertEquals(period.getMins(), 40);
    }

}

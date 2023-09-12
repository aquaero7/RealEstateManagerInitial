package com.openclassrooms.realestatemanagerinitial;

// import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

public class UtilsTest {

    float rate;
    Calendar cal;
    String dateString;

    private void initData() {
        // Init conversion rate
        rate = 0.812f;

        // Init and format current date
        cal = Calendar.getInstance();
        String y = String.valueOf(cal.get(Calendar.YEAR));
        String m = String.valueOf(cal.get(Calendar.MONTH) + 1);
        if (m.length() == 1) m = "0" + m;
        String d = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        if (d.length() == 1) d = "0" + d;

        dateString = d + "/" + m + "/" + y;
    }

    @Before
    public void setup() {
        initData();
    }


    @Test
    public void convertDollarToEuroWithSuccess() {
        assertEquals((int)(rate * 1000), Utils.convertDollarToEuro(1000), 0);
    }

    @Test
    public void convertEuroToDollarWithSuccess() {
        assertEquals((1000), Utils.convertEuroToDollar((int)(rate * 1000)), 0);
    }

    @Test
    public void getTodayDateWithSuccess() {
        assertEquals(dateString, Utils.getTodayDate());
    }





}

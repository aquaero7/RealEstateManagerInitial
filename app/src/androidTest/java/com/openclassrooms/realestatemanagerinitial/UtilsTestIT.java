package com.openclassrooms.realestatemanagerinitial;

import static org.junit.Assert.*;

import android.content.Context;

import android.support.test.InstrumentationRegistry;

import org.junit.Test;

public class UtilsTestIT {

    @Test
    public void getInternetAvailabilityWithSuccess() throws InterruptedException {
        Context appContext = InstrumentationRegistry.getTargetContext();

        // Both wifi and mobile are disabled, so internet is unavailable
        InstrumentationRegistry.getInstrumentation().getUiAutomation().executeShellCommand("svc wifi disable");
        InstrumentationRegistry.getInstrumentation().getUiAutomation().executeShellCommand("svc data disable");
        Thread.sleep(1000);
        assertFalse(Utils.isInternetAvailable(appContext));

        // Wifi is disabled and mobile is enabled, so internet is available
        InstrumentationRegistry.getInstrumentation().getUiAutomation().executeShellCommand("svc data enable");
        Thread.sleep(1000);
        assertTrue(Utils.isInternetAvailable(appContext));

        // Wifi is enabled and mobile is disabled, so internet is available
        InstrumentationRegistry.getInstrumentation().getUiAutomation().executeShellCommand("svc wifi enable");
        InstrumentationRegistry.getInstrumentation().getUiAutomation().executeShellCommand("svc data disable");
        Thread.sleep(3000);
        assertTrue(Utils.isInternetAvailable(appContext));

        // Both wifi and mobile are enabled, so internet is available
        InstrumentationRegistry.getInstrumentation().getUiAutomation().executeShellCommand("svc data enable");
        Thread.sleep(1000);
        assertTrue(Utils.isInternetAvailable(appContext));
    }

}

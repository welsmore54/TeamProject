package com.example.teamproject;

import android.content.Intent;
import android.os.Bundle;

import org.junit.Test;

import java.lang.reflect.Field;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class SeverityScreenTest {

    @Test
    public void verify_that_input__is_less_than_10() {
        SeverityTestScreen severityTest = new SeverityTestScreen();
        try {
            Field userField = severityTest.getClass().getDeclaredField("input");
            userField.setAccessible(true);
            assertTrue((int)userField.get(severityTest) <= 10);
        } catch (Exception e) {
            fail();
            e.printStackTrace();
        }


    }

    @Test
    public void verify_that_input__is_greater_than_0() {
        SeverityTestScreen severityTest = new SeverityTestScreen();
        try {
            Field userField = severityTest.getClass().getDeclaredField("input");
            userField.setAccessible(true);
            assertTrue((int)userField.get(severityTest) >= 0);
        } catch (Exception e) {
            fail();
            e.printStackTrace();
        }


    }

    @Test
    public void verify_that_sum__is_less_than_100() {
        SeverityTestScreen severityTest = new SeverityTestScreen();
        try {
            Field userField = severityTest.getClass().getDeclaredField("sumInput");
            userField.setAccessible(true);
            assertTrue((int)userField.get(severityTest) <= 100);
        } catch (Exception e) {
            fail();
            e.printStackTrace();
        }


    }

    @Test
    public void verify_that_sum_is_greater_than_0() {
        SeverityTestScreen severityTest = new SeverityTestScreen();
        try {
            Field userField = severityTest.getClass().getDeclaredField("sumInput");
            userField.setAccessible(true);
            assertTrue((int)userField.get(severityTest) >= 0);
        } catch (Exception e) {
            fail();
            e.printStackTrace();
        }


    }


}

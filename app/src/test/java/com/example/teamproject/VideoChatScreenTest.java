package com.example.teamproject;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class VideoChatScreenTest {
    
    
    @Test
    public void verify_that_sum_was_received() {
        VideoChatScreen severitySum = new VideoChatScreen();
        try {
            Field userField = severitySum.getClass().getDeclaredField("userField");
            userField.setAccessible(true);
            assertTrue((int)userField.get(severitySum) > 0);
        } catch (Exception e) {
            fail();
            e.printStackTrace();
        }


    }

}

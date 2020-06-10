package com.example.teamproject;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CreateAccountTest {
    @Test
    public void verify_Username_is_Unique() {
        assertTrue( LoginScreen.verify());
    }
    @Test
    public void verify_Username_is_long_enough() {
        assertTrue(LoginScreen.userName.length()>2);
    }

}

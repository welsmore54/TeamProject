package com.example.teamproject;

import org.junit.Test;
import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CreateAccountTest {

    @Test
    public void verify_constructor_works() {
        try {
            LoginScreen loginScreen = new LoginScreen();
            Field userField = loginScreen.getClass().getDeclaredField("userName");
            userField.setAccessible(true);

            assertEquals("default", userField.get(loginScreen));
        }
        catch (Exception e) {
            fail();
            e.printStackTrace();
        }
    }

    @Test
    public void verify_username_is_unique() {
        try {
            assertTrue(LoginScreen.verify());
        }
        catch (Exception e) {
            fail();
            e.printStackTrace();
        }
    }

    @Test
    public void verify_username_is_correct_length() {
        try {
            LoginScreen loginScreen = new LoginScreen();
            Field userField = loginScreen.getClass().getDeclaredField("userName");
            userField.setAccessible(true);

            userField.set("userName", "myUsername");
            loginScreen.checkLength();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void verify_username_is_too_short() {
        try {
            LoginScreen loginScreen = new LoginScreen();
            Field userField = loginScreen.getClass().getDeclaredField("userName");
            userField.setAccessible(true);

            userField.set("userName", "my");
            loginScreen.checkLength();

            // We should never make it farther than here.

            fail("verify_username_is_too_short should have failed on length error.");
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void verify_username_is_too_long() {
        try {
            LoginScreen loginScreen = new LoginScreen();
            Field userField = loginScreen.getClass().getDeclaredField("userName");
            userField.setAccessible(true);

            userField.set("userName", "myUsernamemyUsernamemyUsername");
            loginScreen.checkLength();

            // We should never make it farther than here.

            fail("verify_username_is_too_long should have failed on length error.");
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}

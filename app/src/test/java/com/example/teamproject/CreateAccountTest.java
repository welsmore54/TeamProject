package com.example.teamproject;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

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

    @Test
    public void verify_username_with_database() {
        try {
            final String url = "https://run.mocky.io/v3/e4a51e81-0473-47cb-acd8-7244f4711f68";
            String databaseInfo = databaseConnection.connectToDatabase(url);

            assertEquals("Connected to accepted username database.", databaseInfo, "You have connected to the database successfully :) Login is granted ");
        } catch (Exception e) {
            assertTrue("should have failed comparing JSON string.", false);
        }
    }

    @Test
    public void verify_username_incorrect_with_database() {
        try {
            final String url = "https://run.mocky.io/v3/731b6565-557d-44bc-9b57-92f445827df1";
            String databaseInfo = databaseConnection.connectToDatabase(url);

            assertEquals("Connected to accepted username database.", databaseInfo, "");
        } catch (Exception e) {
            assertTrue("Empty string was not returned from database indicating an incorrect username", false);
        }
    }
}

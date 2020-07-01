package com.example.teamproject;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConnectionTest {
    private String url = "https://run.mocky.io/v3/e4a51e81-0473-47cb-acd8-7244f4711f68"; // should be successful
    //private String url = "https://run.mocky.io/v3/731b6565-557d-44bc-9b57-92f445827df1"; // should be failure
    @Test
    public boolean canConnect(){
        try {
            URLConnection connection = (URLConnection) new URL(url).openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println(readAllLines(bufferedReader));
            assertTrue(true);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            assertTrue("failed to connect", false);
            return false;
        }
    }
    public String readAllLines(BufferedReader reader) throws IOException {
        StringBuilder response = new StringBuilder();
        String line = null;

        while ((line = reader.readLine()) != "") {
            response.append(line);
            response.append(System.lineSeparator());
        }

        return response.toString();
    }
    @Test
    public boolean isConnected(URLConnection connection){

        try {
            if (connection.getInputStream() == null){
                assertTrue("no connection made", false);
                return false; }
            else
                assertTrue(true);
                return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue("connection failed", false);
        return false;
    }
}

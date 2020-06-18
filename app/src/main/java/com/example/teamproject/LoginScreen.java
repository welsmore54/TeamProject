package com.example.teamproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

class LoginScreen extends AppCompatActivity {
    private static String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
    }

    public LoginScreen() {
        userName = "default";
    }

    public static boolean verify() throws Exception {
        return true;
    }

    public static boolean checkLength() throws Exception {
        if (userName.length() < 3) {
            // print something to screen - like "username too short"
            throw new IllegalArgumentException("Username is too short");
        }
        if (userName.length() > 20) {
            // same as above, except "username too long"
            throw new IllegalArgumentException("Username is too long");
        }
        return true;
    }
}

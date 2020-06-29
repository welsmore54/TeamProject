package com.example.teamproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;

public class VideoChatScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_chat_screen);
    }

    public static void receive_sum() {
        SeverityTestScreen severityTest = new SeverityTestScreen();
        try {
            Field userField = severityTest.getClass().getDeclaredField("sumInput");
            userField.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

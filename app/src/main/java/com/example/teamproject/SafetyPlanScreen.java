package com.example.teamproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SafetyPlanScreen extends AppCompatActivity implements Form {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.safety_plan_screen);
    }

    @Override
    public void setContent(String text) {

    }

    @Override
    public String getContent() {
        return null;
    }
}

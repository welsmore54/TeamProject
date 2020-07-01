package com.example.teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends AppCompatActivity{

    SharedPreferences prefs;
    public static final String profileName = "profileNameId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        prefs = getSharedPreferences(profileName, Context.MODE_PRIVATE);
        System.out.println("Howdy World!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences.Editor prefEditor = prefs.edit();
        prefEditor.putString(profileName, "Joe Shmoe");
        prefEditor.commit();
        System.out.println(prefs.getString(profileName, "Place holder Joe"));
    }

    void goToVideoChat(View view) {

    }

    void goToLinks(View view) {

    }

    void goToTests(View view) {

    }

    void goToJournal(View view) {

    }

    void goToSafetyPlan(View view) {

    }
}


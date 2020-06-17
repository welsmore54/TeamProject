package com.example.teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    SharedPreferences.Editor prefEditor = prefs.edit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("Howdy World!");
        System.out.println(prefs.getString("profile name", "Place holder Joe"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        prefEditor.putString("profile name", "Joe Shmoe");
        prefEditor.apply();
    }


}

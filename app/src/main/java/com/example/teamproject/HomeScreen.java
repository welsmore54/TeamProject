package com.example.teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity{

    SharedPreferences prefs;
    public static final String profileName = "profileNameId";
    public static final String EXTRA_MESSAGE = "com.example.teamproject.MESSAGE";
    public Button Journal;


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

    public void goToVideoChat(View view) {
        Intent intent = new Intent(this, VideoChatScreen.class);
        boolean message = true;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void goToLinks(View view) {
        Intent intent = new Intent(this, HelpfulLinksScreen.class);
        boolean message = true;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void goToTests(View view) {
        Intent intent = new Intent(this, SeverityTestScreen.class);
        boolean message = true;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void goToJournal(View view) {
        Intent intent = new Intent(this, Journal.class);
        boolean message = true;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void goToSafetyPlan(View view) {
        Intent intent = new Intent(this, SafetyPlanScreen.class);
        boolean message = true;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}


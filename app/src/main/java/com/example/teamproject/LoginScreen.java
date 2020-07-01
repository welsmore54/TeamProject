package com.example.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginScreen extends AppCompatActivity {
    private static String userName;
    public static final String EXTRA_MESSAGE = "com.example.teamproject.MESSAGE";

    // Got rid of MainActivity for now, I don't think that we need it. I pulled all of
    // the relevant stuff out, and left the rest in a comment in case it was important
    // later.

    /*public class MainActivity extends AppCompatActivity {
        private static final String TAG = "MainActivity";
        private Button loginBtn;

        public static final String SHARED_PREFS ="sharedPrefs";
        public static final String TEXT = "text";
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
    }

    public LoginScreen() {
        userName = "default";
    }

    public void goToHomeScreen(View view) {
        Intent intent = new Intent(this, HomeScreen.class);
        boolean message = true;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
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

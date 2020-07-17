package com.example.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teamproject.ui.InitAuthSDKActivity;

public class SeverityTestScreen extends AppCompatActivity {
    private static int sumInput = 0;
    public static final String EXTRA_MESSAGE = "com.example.teamproject.MESSAGE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.severity_test_screen);



    }

    public void determine_input(View view) {
        EditText question1 = (EditText) findViewById(R.id.editText1);
        String question1_5 = question1.getText().toString();
        EditText question2 = (EditText) findViewById(R.id.editText2);
        String question2_5 = question2.getText().toString();
        EditText question3 = (EditText) findViewById(R.id.editText3);
        String question3_5 = question3.getText().toString();
        EditText question4 = (EditText) findViewById(R.id.editText4);
        String question4_5 = question4.getText().toString();
        EditText question5 = (EditText) findViewById(R.id.editText5);
        String question5_5 = question5.getText().toString();
        EditText question6 = (EditText) findViewById(R.id.editText6);
        String question6_5 = question6.getText().toString();
        EditText question7 = (EditText) findViewById(R.id.editText7);
        String question7_5 = question7.getText().toString();
        EditText question8 = (EditText) findViewById(R.id.editText8);
        String question8_5 = question8.getText().toString();
        EditText question9 = (EditText) findViewById(R.id.editText9);
        String question9_5 = question9.getText().toString();
        EditText question10 = (EditText) findViewById(R.id.editText10);
        String question10_5 = question10.getText().toString();

        int value1 = Integer.parseInt(question1_5);
        int value2 = Integer.parseInt(question2_5);
        int value3 = Integer.parseInt(question3_5);
        int value4 = Integer.parseInt(question4_5);
        int value5 = Integer.parseInt(question5_5);
        int value6 = Integer.parseInt(question6_5);
        int value7 = Integer.parseInt(question7_5);
        int value8 = Integer.parseInt(question8_5);
        int value9 = Integer.parseInt(question9_5);
        int value10 = Integer.parseInt(question10_5);

        sumInput = value1 + value2 + value3 + value4 + value5 + value6 + value7 + value8 + value9 + value10;
        System.out.println(sumInput);

        Intent intent = new Intent(this, InitAuthSDKActivity.class);
        boolean message = true;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
}

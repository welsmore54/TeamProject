package com.example.teamproject;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class SafetyPlanScreen extends AppCompatActivity implements Form {

    String content;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.safety_plan_screen);
    }

    @Override
    public void setContent(String text) {
    content = text;
    }

    @Override
    public String getContent() {
        return content;
    }

    public void update(View view){

        TextView textView = (TextView)findViewById(R.id.editText14);
        textView.setText(content);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String readAllLines(BufferedReader reader) throws IOException {
        StringBuilder response = new StringBuilder();
        String line = null;

        while ((line = reader.readLine()) != "") {
            response.append(line);
            response.append(System.lineSeparator());
        }

        return response.toString();
}
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String getContentURL() {
        try {
            URLConnection connection = (URLConnection) new URL(url).openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            return readAllLines(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

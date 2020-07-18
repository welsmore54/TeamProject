package com.example.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.teamproject.ui.InitAuthSDKActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Journal extends AppCompatActivity implements View.OnClickListener {

    private List<Entry> entries = new ArrayList<>();
    private File file = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.journal);

        file = new File(this.getFilesDir(), "entries.xml");

        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                ArrayList myList = (ArrayList) objectInputStream.readObject();
                objectInputStream.close();

                entries = myList;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < entries.size(); i++) {
            LinearLayout buttonZone = (LinearLayout) findViewById(R.id.buttonZone);
            Button btnTag = new Button(this);
            btnTag.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            btnTag.setText("Journal Entry " + (i + 1));
            btnTag.setId(i);
            btnTag.setOnClickListener(this);

            buttonZone.addView(btnTag);
        }
    }

    public void launchEntryEditor(View view) {
        Intent intent = new Intent(this, JournalEditor.class);
        intent.putExtra("shouldLoad", false);
        startActivity(intent);
    }

    public void goHome(View view) {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, JournalEditor.class);
        intent.putExtra("id", v.getId());
        intent.putExtra("shouldLoad", true);
        startActivity(intent);
    }
}

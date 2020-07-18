package com.example.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class JournalEditor extends AppCompatActivity implements View.OnClickListener {

    private List<Entry> entries = new ArrayList<>();
    private int listID = 0;
    private boolean shouldLoad = false;
    public static final String EXTRA_MESSAGE = "com.example.teamproject.MESSAGE";
    private EditText writeArea = null;
    private File file = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editjournal);

        Button submit = (Button) findViewById(R.id.button8);
        writeArea = (EditText) findViewById(R.id.userEntry);

        file = new File(this.getFilesDir(), "entries.xml");
        Bundle b = getIntent().getExtras();

        listID = b.getInt("id");
        shouldLoad = b.getBoolean("shouldLoad");

        if (shouldLoad) {
            submit.setText("Save & Return");
            submit.setOnClickListener(this);

            LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout6);

            Button btnTag = new Button(this);
            btnTag.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            btnTag.setText("Delete Entry");
            btnTag.setId((int)5);
            btnTag.setOnClickListener(this);

            layout.addView(btnTag);

            if (file.exists()) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                    List myList = (ArrayList) objectInputStream.readObject();
                    objectInputStream.close();

                    entries = myList;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            writeArea.setText(entries.get(listID).getContent());
        }
    }

    public void addEntry(View view) {
        Entry entry = new Entry();
        EditText userEntryAccess = (EditText) findViewById(R.id.userEntry);
        String userEntry = userEntryAccess.getText().toString();

        entry.setContent(userEntry);

        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                List myList = (ArrayList) objectInputStream.readObject();
                objectInputStream.close();

                entries = myList;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        entries.add(entry);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(entries);
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(this, Journal.class);
        boolean message = true;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void cancelEntry(View view) {
        Intent intent = new Intent(this, Journal.class);
        boolean message = true;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() != (int)5) {
            Entry entry = new Entry();
            writeArea = (EditText) findViewById(R.id.userEntry);
            entry.setContent(writeArea.getText().toString());
            entries.set(listID, entry);

            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                objectOutputStream.writeObject(entries);
                objectOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(this, Journal.class);
            boolean message = true;
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        } else if (v.getId() == (int)5) {
            entries.remove(listID);

            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                objectOutputStream.writeObject(entries);
                objectOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(this, Journal.class);
            boolean message = true;
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    }
}

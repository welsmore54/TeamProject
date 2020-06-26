package com.example.teamproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class Journal extends AppCompatActivity {

    private Map<String, Entry> entries = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.journal);
    }

    public void displaySelection(String date) throws Exception {
        if (entries.containsKey(date)) {
            System.out.println(entries.get(date).getContent());
        }
        else {
            throw new Exception("Entry not found");
        }
    }

    public void addEntry(String date, String content) throws Exception {
        Entry entry = new Entry();
        entry.setContent(content);

        if (content.length() > 0) {
            entries.put("06/23/2020", entry);
        }
        else {
            throw new Exception("There was no content in the entry");
        }
    }

    public void removeEntry(String date) throws Exception {
        if (entries.containsKey(date)) {
            entries.remove(date);
        }
        else {
            throw new Exception("Entry not found");
        }
    }

}

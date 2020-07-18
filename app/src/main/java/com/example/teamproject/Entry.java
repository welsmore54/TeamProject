package com.example.teamproject;

import java.io.Serializable;

public class Entry implements Form, Serializable {

    private String content;

    @Override
    public void setContent(String text) {
        this.content = text;
    }

    @Override
    public String getContent() {
        return content;
    }

}

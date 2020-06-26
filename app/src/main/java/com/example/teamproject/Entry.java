package com.example.teamproject;

public class Entry implements Form {

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

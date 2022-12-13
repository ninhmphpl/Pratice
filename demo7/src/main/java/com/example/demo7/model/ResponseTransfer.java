package com.example.demo7.model;

public class ResponseTransfer {
    private String text;

    public ResponseTransfer(String s) {
        text = s;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // standard getters/setters
}
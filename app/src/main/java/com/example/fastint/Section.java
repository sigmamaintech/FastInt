package com.example.fastint;

public class Section {
    private String title;
    private int imageResourceId;

    public Section(String title, int imageResourceId) {
        this.title = title;
        this.imageResourceId = imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}


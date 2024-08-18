package com.hackafun.friendy2.model;

import java.util.Date;

public class Friend {
    private int id;
    private String username;
    private String addedOn;
    private int similarity;
    private String imageUri;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public int getSimilarity() {
        return similarity;
    }

    public void setSimilarity(int similarity) {
        this.similarity = similarity;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public Friend(int id, String username, String addedOn, int similarity, String imageUri) {
        this.id = id;
        this.username = username;
        this.addedOn = addedOn;
        this.similarity = similarity;
        this.imageUri = imageUri;
    }
}

package com.hackafun.friendy2.model;

public class FriendMatchingModel {
    private int id;

    private String username;
    private int match;
    private String desc;
    private String message;
    private int similarity;
    private int distance;
    private String imageUri;

    public FriendMatchingModel(int id, String username, int match, String desc, String message, int similarity, int distance, String imageUri) {
        this.id = id;
        this.username = username;
        this.match = match;
        this.desc = desc;
        this.message = message;
        this.similarity = similarity;
        this.distance = distance;
        this.imageUri = imageUri;
    }

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

    public int getMatch() {
        return match;
    }

    public void setMatch(int match) {
        this.match = match;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSimilarity() {
        return similarity;
    }

    public void setSimilarity(int similarity) {
        this.similarity = similarity;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}

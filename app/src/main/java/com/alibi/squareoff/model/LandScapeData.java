package com.alibi.squareoff.model;

public class LandScapeData {

    String name;
    String image;

    public LandScapeData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LandScapeData(String name, String image) {
        this.name = name;
        this.image = image;
    }
}

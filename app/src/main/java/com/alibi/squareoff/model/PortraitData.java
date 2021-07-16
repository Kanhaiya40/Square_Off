package com.alibi.squareoff.model;

public class PortraitData {

    String name;
    String slug;
    String year;
    String noOfDashCharacter;
    String image;

    public PortraitData(String name, String slug, String year, String noOfDashCharacter, String image) {
        this.name = name;
        this.slug = slug;
        this.year = year;
        this.noOfDashCharacter = noOfDashCharacter;
        this.image = image;
    }

    public PortraitData(String name, String slug, String year, String noOfDashCharacter) {
        this.name = name;
        this.slug = slug;
        this.year = year;
        this.noOfDashCharacter = noOfDashCharacter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNoOfDashCharacter() {
        return noOfDashCharacter;
    }

    public void setNoOfDashCharacter(String noOfDashCharacter) {
        this.noOfDashCharacter = noOfDashCharacter;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

package com.alibi.squareoff.model;

public class TransResponseData {

    private String name;

    private String slug;
    private String img;
    private Integer status;

    public TransResponseData(String name, String slug, Integer status) {
        this.name = name;
        this.slug = slug;
        this.status = status;
    }

    public TransResponseData(String name, String slug, String img, Integer status) {
        this.name = name;
        this.slug = slug;
        this.img = img;
        this.status = status;
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

    @Override
    public String toString() {
        return "TransResponseData{" +
                "name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", img='" + img + '\'' +
                ", status=" + status +
                '}';
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

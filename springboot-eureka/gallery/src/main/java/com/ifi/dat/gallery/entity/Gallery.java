package com.ifi.dat.gallery.entity;

import java.util.List;

public class Gallery {
    private String id;
    private List<Object> images;

    public Gallery(String id, List<Object> images) {
        this.id = id;
        this.images = images;
    }

    public Gallery() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Object> getImages() {
        return images;
    }

    public void setImages(List<Object> images) {
        this.images = images;
    }
}

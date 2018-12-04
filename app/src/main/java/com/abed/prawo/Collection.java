package com.abed.prawo;

import java.util.List;

public class Collection {
    private String name;
    private String imageUrl;
    private List<Item> items;

    public Collection() {
    }

    public Collection(String name, String imageUrl, List<Item> items) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

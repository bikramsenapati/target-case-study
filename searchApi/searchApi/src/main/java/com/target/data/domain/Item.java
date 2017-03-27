package com.target.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Represents the item.
 */
public class Item {

    private String title;
    private String description;
    private String brand;
    private String color;

    @JsonIgnore
    private String value;

    public Item(String title, String description, String brand, String color) {
        this.title = title;
        this.description = description;
        this.brand = brand;
        this.color = color;
        this.value = title + " " + description + " " + brand + " " + color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
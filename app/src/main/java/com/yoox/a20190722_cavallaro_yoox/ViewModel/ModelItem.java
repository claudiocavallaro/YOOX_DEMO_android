package com.yoox.a20190722_cavallaro_yoox.View;

public class ModelItem {

    /* This is a class that can handle all the object i have to display because
    *
    * Item contains an array of available colors but i have to display an item for any color
    * */

    private String id;

    private String brand;
    private String category;

    private String price;

    private String URL;

    public ModelItem(String id, String brand, String category, String price, String URL) {
        this.id = id;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.URL = URL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}

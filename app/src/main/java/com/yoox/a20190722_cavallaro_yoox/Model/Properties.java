package com.yoox.a20190722_cavallaro_yoox.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Properties {

    @SerializedName("Brand")
    private Brand brand;

    @SerializedName("Category")
    private Category category;

    @SerializedName("FormattedPrice")
    private Price price;

    @SerializedName("ItemDescriptions")
    private ItemDetails details;

    @SerializedName("Colors")
    private ArrayList<ColorDetails> colorDetails;

    @SerializedName("Sizes")
    private ArrayList<SizeDetails> sizeDetails;



    public Properties(Brand brand, Category category, Price price, ItemDetails details, ArrayList<ColorDetails> colorDetails, ArrayList<SizeDetails> sizeDetails) {
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.details = details;
        this.colorDetails = colorDetails;
        this.sizeDetails = sizeDetails;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public ItemDetails getDetails() {
        return details;
    }

    public void setDetails(ItemDetails details) {
        this.details = details;
    }

    public ArrayList<ColorDetails> getColorDetails() {
        return colorDetails;
    }

    public void setColorDetails(ArrayList<ColorDetails> colorDetails) {
        this.colorDetails = colorDetails;
    }

    public ArrayList<SizeDetails> getSizeDetails() {
        return sizeDetails;
    }

    public void setSizeDetails(ArrayList<SizeDetails> sizeDetails) {
        this.sizeDetails = sizeDetails;
    }

}

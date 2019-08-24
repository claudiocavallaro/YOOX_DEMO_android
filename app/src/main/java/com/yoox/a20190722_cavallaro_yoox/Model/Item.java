package com.yoox.a20190722_cavallaro_yoox.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Item {

    //Annotation for retrofit

    @SerializedName("Cod10")
    private String cod10;

    @SerializedName("Brand")
    private String brandName;

    @SerializedName("MicroCategory")
    private String category;

    private String price;

    @SerializedName("FormattedFullPrice")
    private String formattedPrice;

    @SerializedName("FormattedDiscountedPrice")
    private String discountedPrice;

    @SerializedName("Sizes")
    private ArrayList<Size> availableSize;

    @SerializedName("Colors")
    private ArrayList<Colors> availableColors;

    public String getCod10() {
        return cod10;
    }

    public void setCod10(String cod10) {
        this.cod10 = cod10;
    }

    public Item(String cod10, String brandName, String category, String formattedPrice, String discountedPrice,
                ArrayList<Size> availableSize, ArrayList<Colors> availableColors) {

        this.cod10 = cod10;
        this.brandName = brandName;
        this.category = category;
        this.formattedPrice = formattedPrice;
        this.discountedPrice = discountedPrice;
        this.availableSize = availableSize;
        this.availableColors = availableColors;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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

    public String getPriceF() {
        return formattedPrice;
    }

    public void setPriceF(String formattedPrice) {
        this.formattedPrice = formattedPrice;
    }

    public String getPriced() {
        return discountedPrice;
    }

    public void setPriced(String discountedPrice) {
        this.discountedPrice = discountedPrice;
    }


    public ArrayList<Size> getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(ArrayList<Size> availableSize) {
        this.availableSize = availableSize;
    }

    public ArrayList<Colors> getAvailableColors() {
        return availableColors;
    }

    public void setAvailableColors(ArrayList<Colors> availableColors) {
        this.availableColors = availableColors;
    }

    public String toString(){

        return brandName + " " + category + " " + price +  " SIZES " + availableSize.toString() + "\nCOLORS " + availableColors.toString() + "\n";
    }

    // This is used for diplaying the correct price
    public void setPriceDef() {
        if (discountedPrice.equals(formattedPrice)){
            price = formattedPrice;
        } else {
            price = discountedPrice;
        }
    }

}

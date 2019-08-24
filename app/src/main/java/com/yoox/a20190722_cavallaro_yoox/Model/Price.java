package com.yoox.a20190722_cavallaro_yoox.Model;

import com.google.gson.annotations.SerializedName;

public class Price {

    @SerializedName("FullPrice")
    private String fullprice;

    @SerializedName("DiscountedPrice")
    private String discountprice;

    private String price;

    public Price(String fullprice, String discountprice) {
        this.fullprice = fullprice;
        this.discountprice = discountprice;
    }

    public String getFullprice() {
        return fullprice;
    }

    public void setFullprice(String fullprice) {
        this.fullprice = fullprice;
    }

    public String getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(String discountprice) {
        this.discountprice = discountprice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice() {
        if (fullprice.equals(discountprice)){
            this.price = fullprice;
        } else {
            this.price = discountprice;
        }
    }
}

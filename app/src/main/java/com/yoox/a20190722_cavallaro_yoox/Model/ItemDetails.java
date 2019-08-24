package com.yoox.a20190722_cavallaro_yoox.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ItemDetails {

    @SerializedName("SizeInfo")
    private String sizeInfo;

    @SerializedName("ProductInfo")
    private ArrayList<String> productInfo;

    @SerializedName("BrandInfo")
    private String brandInfo;

    @SerializedName("ShippingInfo")
    private ShippingDetail shippingDetail;

    public ItemDetails(String sizeInfo, ArrayList<String> productInfo, String brandInfo, ShippingDetail shippingDetail) {
        this.sizeInfo = sizeInfo;
        this.productInfo = productInfo;
        this.brandInfo = brandInfo;
        this.shippingDetail = shippingDetail;
    }

    public String getSizeInfo() {
        return sizeInfo;
    }

    public void setSizeInfo(String sizeInfo) {
        this.sizeInfo = sizeInfo;
    }

    public ArrayList<String> getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ArrayList<String> productInfo) {
        this.productInfo = productInfo;
    }

    public String getBrandInfo() {
        return brandInfo;
    }

    public void setBrandInfo(String brandInfo) {
        this.brandInfo = brandInfo;
    }

    public ShippingDetail getShippingDetail() {
        return shippingDetail;
    }

    public void setShippingDetail(ShippingDetail shippingDetail) {
        this.shippingDetail = shippingDetail;
    }
}

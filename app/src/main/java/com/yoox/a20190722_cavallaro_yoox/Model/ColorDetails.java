package com.yoox.a20190722_cavallaro_yoox.Model;

import android.graphics.Color;

import com.google.gson.annotations.SerializedName;

public class ColorDetails {

    @SerializedName("ColorId")
    private int colorId;

    @SerializedName("ColorCode")
    private String colorCode;

    @SerializedName("Code10")
    private String code10;

    @SerializedName("Name")
    private String name;

    @SerializedName("Rgb")
    private String rgb;

    public ColorDetails(int colorId, String colorCode, String code10, String name, String rgb) {
        this.colorId = colorId;
        this.colorCode = colorCode;
        this.code10 = code10;
        this.name = name;
        this.rgb = rgb;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getCode10() {
        return code10;
    }

    public void setCode10(String code10) {
        this.code10 = code10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRgb() {
        return rgb;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb;
    }

}

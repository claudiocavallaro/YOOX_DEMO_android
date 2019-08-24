package com.yoox.a20190722_cavallaro_yoox.Model;

import com.google.gson.annotations.SerializedName;

public class Colors {

    // This annotation is for retrofit request

    @SerializedName("Id")
    private int id;

    @SerializedName("Cod10")
    private String cod10;

    @SerializedName("Description")
    private String description;

    @SerializedName("Rgb")
    private String rgb;

    public Colors(int id, String cod10, String description, String rgb) {
        this.id = id;
        this.cod10 = cod10;
        this.description = description;
        this.rgb = rgb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCod10() {
        return cod10;
    }

    public void setCod10(String cod10) {
        this.cod10 = cod10;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRgb() {
        return rgb;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb;
    }

    public String toString(){
        return "ID " + id + " cod10 " + cod10 + " descr " + description + " rgb " + rgb;
    }
}

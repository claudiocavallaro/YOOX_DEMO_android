package com.yoox.a20190722_cavallaro_yoox.Model;

import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("Name")
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

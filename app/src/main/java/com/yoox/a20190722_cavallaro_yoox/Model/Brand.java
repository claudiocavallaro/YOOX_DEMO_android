package com.yoox.a20190722_cavallaro_yoox.Model;

import com.google.gson.annotations.SerializedName;

public class Brand {

    @SerializedName("Name")
    private String name;

    public Brand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

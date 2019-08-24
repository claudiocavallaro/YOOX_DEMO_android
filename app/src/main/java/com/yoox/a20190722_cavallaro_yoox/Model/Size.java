package com.yoox.a20190722_cavallaro_yoox.Model;

import com.google.gson.annotations.SerializedName;

public class Size {

    // Annotation for retrofit

    @SerializedName("Text")
    private String text;

    public Size(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String toString(){
        return "TAGLIA " + text;
    }
}

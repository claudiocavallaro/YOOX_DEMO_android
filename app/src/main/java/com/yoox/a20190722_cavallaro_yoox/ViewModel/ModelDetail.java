package com.yoox.a20190722_cavallaro_yoox.ViewModel;

public class ModelDetail {

    /* This class is for list view model of size and colors.
    Code can't be part of constructor because it only refer color
    * */

    private String text;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ModelDetail(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

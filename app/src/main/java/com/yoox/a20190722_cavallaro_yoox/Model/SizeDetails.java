package com.yoox.a20190722_cavallaro_yoox.Model;

import com.google.gson.annotations.SerializedName;

public class SizeDetails {

    @SerializedName("Id")
    private int id;

    @SerializedName("Name")
    private String name;

    @SerializedName("IsoTwoLetterCountryCode")
    private String twoLetter;

    @SerializedName("DefaultSizeLabel")
    private String defaultSize;

    @SerializedName("AlternativeSizeLabel")
    private String alternativeSize;


    public SizeDetails(int id, String name, String twoLetter, String defaultSize, String alternativeSize) {
        this.id = id;
        this.name = name;
        this.twoLetter = twoLetter;
        this.defaultSize = defaultSize;
        this.alternativeSize = alternativeSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTwoLetter() {
        return twoLetter;
    }

    public void setTwoLetter(String twoLetter) {
        this.twoLetter = twoLetter;
    }

    public String getDefaultSize() {
        return defaultSize;
    }

    public void setDefaultSize(String defaultSize) {
        this.defaultSize = defaultSize;
    }

    public String getAlternativeSize() {
        return alternativeSize;
    }

    public void setAlternativeSize(String alternativeSize) {
        this.alternativeSize = alternativeSize;
    }
}

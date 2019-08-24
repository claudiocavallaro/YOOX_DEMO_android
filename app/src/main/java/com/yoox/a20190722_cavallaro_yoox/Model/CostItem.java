package com.yoox.a20190722_cavallaro_yoox.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CostItem {

    @SerializedName("Title")
    private String title;


    @SerializedName("Cells")
    private ArrayList<Values> listnote;

    public CostItem(String title, ArrayList<Values> listnote) {
        this.title = title;
        this.listnote = listnote;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Values> getListnote() {
        return listnote;
    }

    public void setListnote(ArrayList<Values> listnote) {
        this.listnote = listnote;
    }
}

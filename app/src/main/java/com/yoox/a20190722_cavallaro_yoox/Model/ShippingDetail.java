package com.yoox.a20190722_cavallaro_yoox.Model;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class ShippingDetail implements Serializable {

    @SerializedName("ShippingNotes")
    private ArrayList<ShippingNotes> notes;

    @SerializedName("ShippingCosts")
    private ArrayList<CostItem> costItems;

    public ShippingDetail(ArrayList<ShippingNotes> notes, ArrayList<CostItem> costItems) {
        this.notes = notes;
        this.costItems = costItems;
    }

    public ArrayList<ShippingNotes> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<ShippingNotes> notes) {
        this.notes = notes;
    }

    public ArrayList<CostItem> getCostItems() {
        return costItems;
    }

    public void setCostItems(ArrayList<CostItem> costItems) {
        this.costItems = costItems;
    }
}

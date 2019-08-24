package com.yoox.a20190722_cavallaro_yoox.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Search {

    // Annotation for retrofit

    @SerializedName("SearchResultTitle")
    private String title;

    @SerializedName("Items")
    private ArrayList<Item> lista;

    public Search(String title, ArrayList<Item> lista) {
        this.title = title;
        this.lista = lista;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Item> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Item> lista) {
        this.lista = lista;
    }


    public String toString(){
        return title + " " + lista.toString();
    }
}

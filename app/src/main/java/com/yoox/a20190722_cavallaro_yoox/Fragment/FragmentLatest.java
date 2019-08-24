package com.yoox.a20190722_cavallaro_yoox.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yoox.a20190722_cavallaro_yoox.Model.Colors;
import com.yoox.a20190722_cavallaro_yoox.Model.Item;
import com.yoox.a20190722_cavallaro_yoox.Model.Search;
import com.yoox.a20190722_cavallaro_yoox.Persistence.Communicator;
import com.yoox.a20190722_cavallaro_yoox.R;
import com.yoox.a20190722_cavallaro_yoox.ViewModel.ListAdapterItem;
import com.yoox.a20190722_cavallaro_yoox.ViewModel.ModelItem;

import java.util.ArrayList;

public class FragmentLatest extends Fragment {

    private View view;

    private Communicator communicator;

    private ArrayList<ModelItem> modelItems = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ListAdapterItem listAdapterItem;

    private Search search;

    // ------------------------- GETTER AND SETTER-------------------------------

    public Communicator getCommunicator() {
        return communicator;
    }

    public void setCommunicator(Communicator communicator) {
        this.communicator = communicator;
    }

    public ArrayList<ModelItem> getModelItems() {
        return modelItems;
    }

    public void setModelItems(ArrayList<ModelItem> modelItems) {
        this.modelItems = modelItems;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    public ListAdapterItem getListAdapterItem() {
        return listAdapterItem;
    }

    public void setListAdapterItem(ListAdapterItem listAdapterItem) {
        this.listAdapterItem = listAdapterItem;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    //------------------------------------------------------------------------------------------

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_latest, null);
        communicator = new Communicator();

        Toast.makeText(getContext(), "Perform latest request", Toast.LENGTH_SHORT).show();
        communicator.getLatest(this);

        return view;
    }

    public void setView() {

        for (Item item: search.getLista()){
            ArrayList<Colors> colorAvail = item.getAvailableColors();
            for (Colors colors : colorAvail){

                String cod10 = colors.getCod10();
                String[] cod10A = cod10.split("(?!^)");
                String url = "http://cdn.yoox.biz/";
                url +=   cod10A[0] +  cod10A[1] + "/" + cod10 + "_11_f.jpg";

                String id = cod10.substring(0, cod10.length()-2);

                modelItems.add(new ModelItem(id, item.getBrandName(), item.getCategory(), item.getPrice(), url));

            }
        }



        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_viewLA);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        listAdapterItem = new ListAdapterItem(getContext(), modelItems);

        recyclerView.setAdapter(listAdapterItem);
    }
}

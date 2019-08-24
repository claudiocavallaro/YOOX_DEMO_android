package com.yoox.a20190722_cavallaro_yoox.Fragment;

import android.content.Intent;
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

import com.yoox.a20190722_cavallaro_yoox.Activity.DetailActivity;
import com.yoox.a20190722_cavallaro_yoox.Activity.MainActivity;
import com.yoox.a20190722_cavallaro_yoox.Model.Colors;
import com.yoox.a20190722_cavallaro_yoox.Model.Item;
import com.yoox.a20190722_cavallaro_yoox.Model.Search;
import com.yoox.a20190722_cavallaro_yoox.Persistence.Communicator;
import com.yoox.a20190722_cavallaro_yoox.R;
import com.yoox.a20190722_cavallaro_yoox.ViewModel.ListAdapterItem;
import com.yoox.a20190722_cavallaro_yoox.ViewModel.ModelItem;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    private View view;

    private Communicator communicator;

    private ArrayList<ModelItem> modelItems = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ListAdapterItem listAdapterItem;

    private Search search;

    // I use this counter for endless scroll and managing the three requests
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

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

        view = inflater.inflate(R.layout.fragment_home, null);

        communicator = new Communicator();

        Toast.makeText(getContext(), "Perform first request", Toast.LENGTH_SHORT).show();
        communicator.getItem(this, "searchresult");


        return view;
    }

    public void setView() {

        if (counter == 0){
            // Only the first time i initialize everything because it is not convenient to restart from the first item in the list

            recyclerView = (RecyclerView) view.findViewById(R.id.recycler_viewF);
            layoutManager = new LinearLayoutManager(this.getContext());
            recyclerView.setLayoutManager(layoutManager);

            listAdapterItem = new ListAdapterItem(getContext(), modelItems);

            recyclerView.setAdapter(listAdapterItem);

        }
        if (counter > 0 ){
            listAdapterItem.notifyDataSetChanged();
        }

        // For every request I add the items from the current requests

        for (Item item : search.getLista()) {
            ArrayList<Colors> colorAvail = item.getAvailableColors();
            for (Colors colors : colorAvail) {

                // This is for preparing URL image
                String cod10 = colors.getCod10();
                String[] cod10A = cod10.split("(?!^)");
                String url = "http://cdn.yoox.biz/";
                url += cod10A[0] + cod10A[1] + "/" + cod10 + "_11_f.jpg";

                /* In real situation if I tap on an item i should receive details of the tapped one.
                    In Item the API give Cod10 of just one color and so if I search for a Cod10 of a color
                    I can receive no item. So, I guess we can exclude the last 2 character from there
                    that identify the color and perform correctly a complete search of the item,
                    with contains method.
                * */
                String id = cod10.substring(0, cod10.length() - 2);

                modelItems.add(new ModelItem(id, item.getBrandName(), item.getCategory(), item.getPrice(), url));

            }
        }


        listAdapterItem.setClickListener(new ListAdapterItem.ClickListener() {
            @Override
            public void itemClicked(View view, int position) {
                /* With View and position I can track the item where I tap
                 but i have to perform always the same request
                 models.get(position).getId()
                 return the cod10 field in Colors (first request) less than 2 char that identify the color
                */

                Intent i = new Intent(getActivity(), DetailActivity.class);
                startActivity(i);
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    if (recyclerView.canScrollVertically(RecyclerView.FOCUS_DOWN) == false) {
                        if (counter == 0){
                            Toast.makeText(getContext(), "Perform second request", Toast.LENGTH_SHORT).show();
                            communicator.getItem(FragmentHome.this, "searchresult2");
                        } else if (counter == 1){
                            Toast.makeText(getContext(), "Perform third request", Toast.LENGTH_SHORT).show();
                            communicator.getItem(FragmentHome.this, "searchresult3");
                        } else if (counter > 1){
                            Toast.makeText(getContext(), "No more request", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });


    }

}

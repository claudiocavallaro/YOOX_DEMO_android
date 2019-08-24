package com.yoox.a20190722_cavallaro_yoox.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.yoox.a20190722_cavallaro_yoox.Model.Colors;
import com.yoox.a20190722_cavallaro_yoox.Model.Item;
import com.yoox.a20190722_cavallaro_yoox.Model.Search;
import com.yoox.a20190722_cavallaro_yoox.Persistence.Communicator;
import com.yoox.a20190722_cavallaro_yoox.R;
import com.yoox.a20190722_cavallaro_yoox.View.ListAdapterItem;
import com.yoox.a20190722_cavallaro_yoox.View.ModelItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Communicator communicator;

    private ArrayList<ModelItem> modelItems = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ListAdapterItem listAdapterItem;

    private Search search;

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        communicator = new Communicator();

        Toast.makeText(this, "Perform first request", Toast.LENGTH_SHORT).show();
        communicator.getItem(this);


    }

    public void showError() {
        Toast.makeText(this, "Network Error", Toast.LENGTH_LONG).show();
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

                System.out.println(id);
                modelItems.add(new ModelItem(id, item.getBrandName(), item.getCategory(), item.getPrice(), url));

            }
        }



        recyclerView = (RecyclerView) findViewById(R.id.recycler_viewG);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        listAdapterItem = new ListAdapterItem(this, modelItems);

        listAdapterItem.setClickListener(new ListAdapterItem.ClickListener() {
            @Override
            public void itemClicked(View view, int position) {
                Toast.makeText(getApplicationContext(), modelItems.get(position).getId(), Toast.LENGTH_LONG).show();
            }
        });

        recyclerView.setAdapter(listAdapterItem);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sort_menu){

        }
        return super.onOptionsItemSelected(item);
    }
}

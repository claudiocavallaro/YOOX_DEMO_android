package com.yoox.a20190722_cavallaro_yoox.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.TextView;

import com.yoox.a20190722_cavallaro_yoox.Model.CostItem;
import com.yoox.a20190722_cavallaro_yoox.Model.ShippingDetail;
import com.yoox.a20190722_cavallaro_yoox.Model.ShippingNotes;
import com.yoox.a20190722_cavallaro_yoox.Model.Values;
import com.yoox.a20190722_cavallaro_yoox.R;
import com.yoox.a20190722_cavallaro_yoox.ViewModel.GridAdapterShip;
import com.yoox.a20190722_cavallaro_yoox.ViewModel.ModelGrid;

import java.util.ArrayList;

public class ShippingActivity extends AppCompatActivity {

    private static ShippingDetail shippingDetail;

    private ArrayList<ModelGrid> modelGrids;

    public static ShippingDetail getShippingDetail() {
        return shippingDetail;
    }

    public static void setShippingDetail(ShippingDetail shippingDetail) {
        ShippingActivity.shippingDetail = shippingDetail;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping);

        TextView textView = (TextView) findViewById(R.id.textShipInfo1);
        String notes = "";
        for (ShippingNotes shippingNotes : shippingDetail.getNotes()){
            if (!shippingNotes.getTitle().equals("")){
                notes += shippingNotes.getTitle() + "\n";
            }
            for (String s : shippingNotes.getNotes()){
                String x = s.replaceAll("<.*?>", "");
                notes += x + "\n";
            }

        }
        textView.setText(notes);

        modelGrids = new ArrayList<>();

        for (int i = 0 ; i < shippingDetail.getCostItems().size() ; i++){
            CostItem costItem = shippingDetail.getCostItems().get(i);
            modelGrids.add(new ModelGrid(costItem.getTitle()));
        }

        for (int i = 0 ; i < shippingDetail.getCostItems().size() ; i++){
            CostItem costItem = shippingDetail.getCostItems().get(i);
            for (int j = 0 ; j < costItem.getListnote().size(); j++){
                Values values = costItem.getListnote().get(j);
                modelGrids.add(new ModelGrid(values.getName().get(0)));
            }
        }

        GridAdapterShip gridAdapterShip = new GridAdapterShip(this, modelGrids);
        GridView gridView = (GridView) findViewById(R.id.gridView);

        gridView.setAdapter(gridAdapterShip);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

package com.yoox.a20190722_cavallaro_yoox.ViewModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.yoox.a20190722_cavallaro_yoox.R;

import java.util.ArrayList;

public class ListAdapterDet extends ArrayAdapter<ModelDetail> {

    private Context context;
    private ArrayList<ModelDetail> modelDetailArrayList;


    public ListAdapterDet(Context context, ArrayList<ModelDetail> modelDetailArrayList){
        super(context, R.layout.list_item, modelDetailArrayList);
        this.context = context;
        this.modelDetailArrayList = modelDetailArrayList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.list_item, parent, false);

        TextView item = (TextView) row.findViewById(R.id.textListItem);
        item.setText(modelDetailArrayList.get(position).getText());

        return row;
    }
}

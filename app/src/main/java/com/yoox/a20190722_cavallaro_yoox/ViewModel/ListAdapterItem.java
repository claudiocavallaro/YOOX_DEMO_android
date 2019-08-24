package com.yoox.a20190722_cavallaro_yoox.ViewModel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yoox.a20190722_cavallaro_yoox.R;

import java.io.InputStream;
import java.util.ArrayList;

public class ListAdapterItem extends RecyclerView.Adapter<ListAdapterItem.ViewHolder> {

    private ArrayList<ModelItem> models;
    private Context context;
    private LayoutInflater inflater;

    private ClickListener clickListener;

    public ListAdapterItem(Context context, ArrayList<ModelItem> models){
        super();
        this.context = context;
        this.models = models;

        inflater = LayoutInflater.from(context);
    }

    public ArrayList<ModelItem> getModels() {
        return models;
    }

    public void setModels(ArrayList<ModelItem> models) {
        this.models = models;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public LayoutInflater getInflater() {
        return inflater;
    }

    public void setInflater(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public ClickListener getClickListener() {
        return clickListener;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        ModelItem item = models.get(i);
        viewHolder.brand.setText(item.getBrand());
        viewHolder.category.setText(item.getCategory());
        viewHolder.price.setText(item.getPrice());
        new DownloadImageTask((ImageView) viewHolder.img).execute(item.getURL());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView brand;
        public TextView category;
        public TextView price;
        public ImageView img;

        public ViewHolder(final View itemView){
            super(itemView);
            brand = (TextView)itemView.findViewById(R.id.textBrand);
            category = (TextView)itemView.findViewById(R.id.textCategory);
            price = (TextView)itemView.findViewById(R.id.textPrice);
            img = (ImageView)itemView.findViewById(R.id.img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (clickListener != null){
                        clickListener.itemClicked(v, getAdapterPosition());
                    }
                }
            });

        }

    }

    public interface ClickListener{
        public void itemClicked(View view, int position);
    }

    public interface LongClickListener{
        public void itemClicked(View view, int position);
    }


    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap>{

        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage){
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}

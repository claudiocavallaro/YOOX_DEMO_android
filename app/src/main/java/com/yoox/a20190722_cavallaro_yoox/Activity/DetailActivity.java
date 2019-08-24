package com.yoox.a20190722_cavallaro_yoox.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.yoox.a20190722_cavallaro_yoox.Model.ColorDetails;
import com.yoox.a20190722_cavallaro_yoox.Model.Colors;
import com.yoox.a20190722_cavallaro_yoox.Model.Properties;
import com.yoox.a20190722_cavallaro_yoox.Model.ShippingDetail;
import com.yoox.a20190722_cavallaro_yoox.Model.ShippingNotes;
import com.yoox.a20190722_cavallaro_yoox.Model.SizeDetails;
import com.yoox.a20190722_cavallaro_yoox.Persistence.Communicator;
import com.yoox.a20190722_cavallaro_yoox.R;
import com.yoox.a20190722_cavallaro_yoox.ViewModel.ListAdapterDet;
import com.yoox.a20190722_cavallaro_yoox.ViewModel.ModelDetail;

import java.io.InputStream;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private Communicator communicator;

    private Properties properties;

    private ArrayList<ModelDetail> modelDetails;
    private ModelDetail item;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        communicator = new Communicator();
        communicator.getDet(this);
    }

    public void setView() {

        Toast.makeText(this, "Click on the color to change the image", Toast.LENGTH_SHORT).show();

        TextView brandDet = (TextView) findViewById(R.id.textBrandDet);
        TextView priceDet = (TextView) findViewById(R.id.priceDet);
        TextView catDet = (TextView) findViewById(R.id.textCategoryDet);

        brandDet.setText(properties.getBrand().getName());
        priceDet.setText(properties.getPrice().getPrice());
        catDet.setText(properties.getCategory().getName());

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailActivity.this, ShippingActivity.class);
                ShippingActivity.setShippingDetail(properties.getDetails().getShippingDetail());
                startActivity(i);
            }
        });

        final ImageView imageView = (ImageView) findViewById(R.id.imageDet);

        String cod10 = properties.getColorDetails().get(0).getCode10();
        String[] cod10A = cod10.split("(?!^)");
        String url = "http://cdn.yoox.biz/";
        url += cod10A[0] + cod10A[1] + "/" + cod10 + "_11_f.jpg";


        new DownloadImageTask(imageView).execute(url);

        TextView infoDet = (TextView) findViewById(R.id.textInfo);
        String completeInfo = "";
        ArrayList<String> info = properties.getDetails().getProductInfo();
        for (String s : info){
            completeInfo += s + "\n";
        }
        infoDet.setText(properties.getDetails().getSizeInfo() + "\n" + completeInfo);

        //------------ LIST VIEW -------------

        modelDetails = new ArrayList<>();

        for (SizeDetails sizeDetails : properties.getSizeDetails()){
            modelDetails.add(new ModelDetail(sizeDetails.getDefaultSize()));
        }

        ListAdapterDet listAdapterDet = new ListAdapterDet(this, modelDetails);
        ListView listViewSize = (ListView) findViewById(R.id.listViewSize);
        listViewSize.setAdapter(listAdapterDet);

        modelDetails = new ArrayList<>();
        for (ColorDetails colorDetails : properties.getColorDetails()){
            ModelDetail modelDetail = new ModelDetail(colorDetails.getName());
            modelDetail.setCode(colorDetails.getCode10());
            modelDetails.add(modelDetail);
        }

        ListAdapterDet listAdapterDetColor = new ListAdapterDet(this, modelDetails);
        final ListView listViewColor = (ListView) findViewById(R.id.listViewColor);
        listViewColor.setAdapter(listAdapterDetColor);

        listViewColor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /*If you click on the color the image will update */
                item = (ModelDetail) listViewColor.getItemAtPosition(position);

                String cod10 = item.getCode();
                String[] cod10A = cod10.split("(?!^)");
                String url = "http://cdn.yoox.biz/";
                url += cod10A[0] + cod10A[1] + "/" + cod10 + "_11_f.jpg";


                new DownloadImageTask(imageView).execute(url);
            }
        });


        //------------------------------------------------------------------------

    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

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

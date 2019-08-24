package com.yoox.a20190722_cavallaro_yoox.Persistence;

import com.yoox.a20190722_cavallaro_yoox.Activity.DetailActivity;
import com.yoox.a20190722_cavallaro_yoox.Model.Item;
import com.yoox.a20190722_cavallaro_yoox.Model.Properties;
import com.yoox.a20190722_cavallaro_yoox.Model.Search;
import com.yoox.a20190722_cavallaro_yoox.Fragment.FragmentHigh;
import com.yoox.a20190722_cavallaro_yoox.Fragment.FragmentHome;
import com.yoox.a20190722_cavallaro_yoox.Fragment.FragmentLatest;
import com.yoox.a20190722_cavallaro_yoox.Fragment.FragmentLow;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Communicator {


    private static final String URL = "http://5aaf9b98bcad130014eeaf0b.mockapi.io/";

    public void getItem(final FragmentHome fragmentHome, String path) {
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).readTimeout(1000, TimeUnit.SECONDS).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();

        Interface api = retrofit.create(Interface.class);

        Call<Search> call = api.getItem(path);

        call.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {

                Search search;
                Search currentSearch;
                ArrayList<Item> itemList;

                if (fragmentHome.getSearch() == null) {
                    search = response.body();
                    for (Item item : search.getLista()) {
                        item.setPriceDef();
                    }

                } else {
                    search = fragmentHome.getSearch();
                    currentSearch = response.body();

                    for (Item item : currentSearch.getLista()) {
                        item.setPriceDef();
                    }

                    search.setLista(currentSearch.getLista());

                    int counter = fragmentHome.getCounter();
                    counter++;
                    fragmentHome.setCounter(counter);

                }

                fragmentHome.setSearch(search);
                fragmentHome.setView();


            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {
                t.printStackTrace();
            }

        });
    }


    public void getLatest(final FragmentLatest fragmentLatest) {
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).readTimeout(1000, TimeUnit.SECONDS).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();

        Interface api = retrofit.create(Interface.class);

        Call<Search> call = api.getLatest();

        call.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {

                Search search = response.body();

                for (Item item : search.getLista()) {
                    item.setPriceDef();
                }

                fragmentLatest.setSearch(search);

                fragmentLatest.setView();
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void getLowest(final FragmentLow fragmentLow) {
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).readTimeout(1000, TimeUnit.SECONDS).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();

        Interface api = retrofit.create(Interface.class);

        Call<Search> call = api.getLowest();

        call.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {

                Search search = response.body();

                for (Item item : search.getLista()) {
                    item.setPriceDef();
                }

                fragmentLow.setSearch(search);

                fragmentLow.setView();
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void getHighest(final FragmentHigh fragmentHigh) {
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).readTimeout(1000, TimeUnit.SECONDS).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();

        Interface api = retrofit.create(Interface.class);

        Call<Search> call = api.getHighest();

        call.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {

                Search search = response.body();

                for (Item item : search.getLista()) {
                    item.setPriceDef();
                }

                fragmentHigh.setSearch(search);

                fragmentHigh.setView();
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


    public void getDet(final DetailActivity detailActivity){
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS).readTimeout(1000, TimeUnit.SECONDS).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();

        Interface api = retrofit.create(Interface.class);

        Call<Properties> call = api.getDet();

        call.enqueue(new Callback<Properties>() {
            @Override
            public void onResponse(Call<Properties> call, Response<Properties> response) {

                Properties properties = response.body();

                properties.getPrice().setPrice();

                detailActivity.setProperties(properties);

                detailActivity.setView();
            }

            @Override
            public void onFailure(Call<Properties> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}

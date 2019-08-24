package com.yoox.a20190722_cavallaro_yoox.Persistence;

import com.yoox.a20190722_cavallaro_yoox.Model.Properties;
import com.yoox.a20190722_cavallaro_yoox.Model.Search;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Interface {

    @GET("ynap/v1/{path}")
    Call<Search> getItem(@Path("path") String path);

    @GET("ynap/v1/latest")
    Call<Search> getLatest();

    @GET("ynap/v1/highest")
    Call<Search> getHighest();

    @GET("ynap/v1/lowest")
    Call<Search> getLowest();

    @GET("ynap/v1/item")
    Call<Properties> getDet();

}

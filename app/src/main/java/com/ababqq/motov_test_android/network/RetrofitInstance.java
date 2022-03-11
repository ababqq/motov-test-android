package com.ababqq.motov_test_android.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private static OkHttpClient mOkHttpClient = null;

    private RetrofitInstance() {
        initOkHttpClient();
    }

    public static RetrofitInstance getInstance() {
        return RetrofitInstance.LazyHolder.INSTANCE;
    }

    private void initOkHttpClient() {
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(4000, TimeUnit.MILLISECONDS)
                .build();
    }

    public Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private static class LazyHolder {
        private static final RetrofitInstance INSTANCE = new RetrofitInstance();
    }
}
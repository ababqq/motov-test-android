package com.ababqq.motov_test_android.api;

import com.ababqq.motov_test_android.entity.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OneCallApi {

    @GET("onecall")
    Call<WeatherResponse> getForecast48h(
            @Query("lat") String lat,
            @Query("lon") String lon,
            @Query("exclude") String exclude,
            @Query("appid") String apiKey
    );
}
package com.ababqq.motov_test_android.api;

import com.ababqq.motov_test_android.entity.WeatherResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OneCallApi {

    @GET("onecall")
    Observable<WeatherResponse> getForecast48h(
            @Query("lat") String lat,
            @Query("lon") String lon,
            @Query("exclude") String exclude,
            @Query("units") String units,
            @Query("appid") String apiKey
    );
}
package com.ababqq.motov_test_android.feature.weather;

import android.annotation.SuppressLint;
import android.util.Log;

import com.ababqq.motov_test_android.api.OneCallApi;
import com.ababqq.motov_test_android.entity.WeatherResponse;
import com.ababqq.motov_test_android.models.GPSBean;
import com.ababqq.motov_test_android.network.RetrofitInstance;
import com.ababqq.motov_test_android.viewmodels.WeatherViewModel;

import java.util.Objects;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class WeatherRepository {
    private static final String TAG = WeatherRepository.class.getSimpleName();
    private final String PARAMS_EXCLUDED = "current,minutely,daily";

    private Observable<WeatherResponse> getForecast48h(GPSBean gps, String apiKey) {
        return RetrofitInstance.getInstance().getRetrofit().create(OneCallApi.class)
                .getForecast48h(gps.getLat().toString(), gps.getLon().toString(), PARAMS_EXCLUDED, apiKey);
    }

    @SuppressLint("CheckResult")
    public void requestForecast48h(WeatherViewModel.OnForecastFetchedListener listener,
                                   GPSBean gps,
                                   String apiKey) {
        getForecast48h(gps, apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        weatherResponse -> {
                            listener.fetchedForecastItems(weatherResponse.getHourly());
                        },
                        error -> {
                            Log.d("requestPhotoList", Objects.requireNonNull(error.getMessage()));
                        }
                );
    }
}

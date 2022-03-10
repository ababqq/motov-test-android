package com.ababqq.motov_test_android.viewmodels;

import android.os.Build;

import androidx.lifecycle.ViewModel;

import com.ababqq.motov_test_android.BuildConfig;
import com.ababqq.motov_test_android.feature.weather.WeatherRepository;
import com.ababqq.motov_test_android.models.GPSBean;
import com.ababqq.motov_test_android.models.HourlyVO;
import com.ababqq.motov_test_android.mvvm.SingleLiveEvent;

import java.util.List;

public class WeatherViewModel extends ViewModel {
    private static final String TAG = WeatherViewModel.class.getSimpleName();

    private WeatherRepository mRepository = new WeatherRepository();

    private SingleLiveEvent<Void> mPermissionEv = new SingleLiveEvent<>();
    private SingleLiveEvent<GPSBean> mGPSEv = new SingleLiveEvent<>();
    private GPSBean mGPS;

    public void initView() {
        mPermissionEv.call();
    }

    public SingleLiveEvent<Void> checkLocationPermissions(){
        return mPermissionEv;
    }

    public SingleLiveEvent<GPSBean> getGPSEv() {
        return mGPSEv;
    }

    public GPSBean getGPS() {
        return mGPS;
    }

    public void setGPS(double longitude, double latitude) {
        mGPS = new GPSBean(longitude, latitude);
        mGPSEv.setValue(mGPS);
    }

    public void loadForecast() {
        mRepository.requestForecast48h(items -> {
                }
        , mGPS, BuildConfig.OPENWEATHERMAP_APIKEY);
    }

    public interface OnForecastFetchedListener {
        void fetchedForecastItems(List<HourlyVO> items);
    }
}
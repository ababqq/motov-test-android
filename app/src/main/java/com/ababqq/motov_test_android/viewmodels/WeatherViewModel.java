package com.ababqq.motov_test_android.viewmodels;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.ababqq.motov_test_android.BuildConfig;
import com.ababqq.motov_test_android.feature.weather.WeatherRepository;
import com.ababqq.motov_test_android.models.GPSBean;
import com.ababqq.motov_test_android.models.HourlyVO;
import com.ababqq.motov_test_android.mvvm.SingleLiveEvent;

import java.util.List;

public class WeatherViewModel extends ViewModel {
    private static final String TAG = WeatherViewModel.class.getSimpleName();
    private int NUMBER_PER_PAGE = 8;

    private WeatherRepository mRepository = new WeatherRepository();

    private SingleLiveEvent<Void> mPermissionEv = new SingleLiveEvent<>();
    private SingleLiveEvent<GPSBean> mGPSEv = new SingleLiveEvent<>();
    private SingleLiveEvent<List<HourlyVO>> mForecast = new SingleLiveEvent<>();

    private SingleLiveEvent<Integer> page = new SingleLiveEvent<>();

    public void initView() {
        mPermissionEv.call();
    }

    public SingleLiveEvent<Void> checkLocationPermissions() {
        return mPermissionEv;
    }

    public SingleLiveEvent<List<HourlyVO>> setForecastItems() {
        return mForecast;
    }

    public SingleLiveEvent<List<HourlyVO>> refreshForecastItems() {
        return mForecast;
    }
    public SingleLiveEvent<GPSBean> getGPSEv() {
        return mGPSEv;
    }

    public GPSBean getGPS() {
        return mGPSEv.getValue();
    }

    public void setGPS(double longitude, double latitude) {
        mGPSEv.setValue(new GPSBean(longitude, latitude));
    }

    public void loadForecast(OnForecastFetchedListener onForecastFetchedListener) {
        page.setValue(0);
        mRepository.requestForecast48h(onForecastFetchedListener
                , mGPSEv.getValue(), BuildConfig.OPENWEATHERMAP_APIKEY);
    }

    public List<HourlyVO> getForcastItems() {
        return mForecast.getValue();
    }

    public SingleLiveEvent<Integer> getPage() {
        if (page.getValue() == null)
            page.setValue(0);
        return page;
    }

    public void loadMorePage() {
        if (mForecast.getValue().size() / NUMBER_PER_PAGE > (page.getValue()+1) )
            page.setValue(page.getValue()+1);
    }

    public int getNUMBER_PER_PAGE() {
        return NUMBER_PER_PAGE;
    }

    public interface OnForecastFetchedListener {
        void fetchedForecastItems(List<HourlyVO> items);
    }
}
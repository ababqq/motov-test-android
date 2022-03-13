package com.ababqq.motov_test_android.viewmodels;

import android.location.Location;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.ababqq.motov_test_android.BuildConfig;
import com.ababqq.motov_test_android.feature.weather.WeatherRepository;
import com.ababqq.motov_test_android.models.GPSBean;
import com.ababqq.motov_test_android.models.HourlyVO;
import com.ababqq.motov_test_android.mvvm.SingleLiveEvent;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.List;

public class WeatherViewModel extends ViewModel {
    private static final String TAG = WeatherViewModel.class.getSimpleName();
    private int NUMBER_PER_PAGE = 8;

    private LocationCallback mLocationCallback;
    private WeatherRepository mRepository = new WeatherRepository();

    private SingleLiveEvent<Void> mPermissionEv = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mGPSCallbackEv = new SingleLiveEvent<>();
    private SingleLiveEvent<GPSBean> mGPS = new SingleLiveEvent<>();
    private SingleLiveEvent<List<HourlyVO>> mForecast = new SingleLiveEvent<>();
    private SingleLiveEvent<Integer> page = new SingleLiveEvent<>();

    public void checkLocationPermission() {
        mPermissionEv.call();
    }

    public void initLocationCallback() {
        mLocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);

                if (locationResult == null) {
                    Log.d(TAG, "Location information have not been recieved");
                    return;
                }
                Log.d(TAG, "Location information have been recieved");

                for (Location location : locationResult.getLocations()) {
                    if (location != null) {
                        if (getGPS().getValue() == null)
                            setGPS(location.getLongitude(), location.getLatitude());
                    }
                }
                mGPSCallbackEv.call();
            }
        };
    }

    public SingleLiveEvent<Void> getLocationPermissions() {
        return mPermissionEv;
    }

    public SingleLiveEvent<List<HourlyVO>> setForecastItems() {
        return mForecast;
    }

    public SingleLiveEvent<List<HourlyVO>> refreshForecastItems() {
        return mForecast;
    }

    public SingleLiveEvent<GPSBean> getGPS() {
        return mGPS;
    }

    public SingleLiveEvent<Void> getGPSCallbackEv() {
        return mGPSCallbackEv;
    }

    public LocationCallback getLocationCallback() {
        return mLocationCallback;
    }


    public void setGPS(double longitude, double latitude) {
        mGPS.setValue(new GPSBean(longitude, latitude));
    }

    public void loadForecast(OnForecastFetchedListener onForecastFetchedListener) {
        if (page.getValue() == null)
            page.setValue(0);
        mRepository.requestForecast48h(onForecastFetchedListener
                , mGPS.getValue(), BuildConfig.OPENWEATHERMAP_APIKEY);
    }

    public List<HourlyVO> getForcastItems() {
        if (mForecast.getValue() == null)
            mForecast.setValue(new ArrayList<>());
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
package com.ababqq.motov_test_android.viewmodels;

import androidx.lifecycle.ViewModel;

import com.ababqq.motov_test_android.models.GPSBean;
import com.ababqq.motov_test_android.mvvm.SingleLiveEvent;

public class WeatherViewModel extends ViewModel {
    private static final String TAG = WeatherViewModel.class.getSimpleName();

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
}
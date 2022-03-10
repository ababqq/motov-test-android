package com.ababqq.motov_test_android.viewmodels;

import androidx.lifecycle.ViewModel;

import com.ababqq.motov_test_android.mvvm.SingleLiveEvent;
import com.google.android.gms.location.LocationRequest;

public class WeatherViewModel extends ViewModel {
    private static final String TAG = WeatherViewModel.class.getSimpleName();

    private SingleLiveEvent<Void> mPermissionEv = new SingleLiveEvent<>();

    public void initView() {
        mPermissionEv.call();
    }

    public SingleLiveEvent<Void> checkLocationPermissions(){
        return mPermissionEv;
    }
}
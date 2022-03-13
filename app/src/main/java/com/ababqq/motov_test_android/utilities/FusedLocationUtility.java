package com.ababqq.motov_test_android.utilities;

import static com.ababqq.motov_test_android.utilities.Constants.REQUEST_LOCATION_PERMISSION;

import android.Manifest;
import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.Fragment;

import com.ababqq.motov_test_android.feature.weather.WeatherFragment;
import com.ababqq.motov_test_android.network.RetrofitInstance;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import pub.devrel.easypermissions.EasyPermissions;

public class FusedLocationUtility {
    private static final String TAG = FusedLocationUtility.class.getSimpleName();

    private static final int DEFAULT_LOCATION_REQUEST_PRIORITY = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY;
    private static LocationRequest locationRequest;

    public static boolean checkLocationPermissions(Context context) {
        return EasyPermissions.hasPermissions(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        );
    }

    public static void requestGMSLocationPermission(Activity activity, OnSuccessListener successListener, OnFailureListener failureListener){
        locationRequest = LocationRequest.create();
        locationRequest.setPriority(DEFAULT_LOCATION_REQUEST_PRIORITY);

        SettingsClient settingsClient = LocationServices.getSettingsClient(activity);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(null).setAlwaysShow(true);
        settingsClient.checkLocationSettings(builder.build())
                .addOnSuccessListener(successListener)
                .addOnFailureListener(failureListener);
    }

    public static void requestPermissions(Fragment fragment) {
        EasyPermissions.requestPermissions(
                fragment,
                "You need to accept location permissions to use this app.",
                REQUEST_LOCATION_PERMISSION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
        );
    }

    public static LocationRequest getLocationRequest() {
        return locationRequest;
    }
}

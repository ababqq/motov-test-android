package com.ababqq.motov_test_android.utilities;

import android.Manifest;
import android.content.Context;

import pub.devrel.easypermissions.EasyPermissions;

public class GPSUtility {

    public static boolean checkLocationPermissions(Context context) {
        return EasyPermissions.hasPermissions(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION
        );
    }
}

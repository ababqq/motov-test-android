package com.ababqq.motov_test_android.feature.weather;

import static android.app.Activity.RESULT_OK;
import static com.ababqq.motov_test_android.utilities.Constants.REQUEST_GMS_PERMISSION;
import static com.ababqq.motov_test_android.utilities.Constants.REQUEST_LOCATION_PERMISSION;

import android.Manifest;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.ababqq.motov_test_android.R;
import com.ababqq.motov_test_android.databinding.WeatherFragmentBinding;
import com.ababqq.motov_test_android.utilities.FusedLocationUtility;
import com.ababqq.motov_test_android.viewmodels.WeatherViewModel;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.List;

import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class WeatherFragment extends Fragment implements EasyPermissions.PermissionCallbacks {

    private static final String TAG = WeatherFragment.class.getSimpleName();

    private WeatherViewModel mViewModel;
    private WeatherFragmentBinding mBinding;

    public static WeatherFragment newInstance() {
        return new WeatherFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(WeatherViewModel.class);
        observeLocationPermissions();
        mViewModel.initView();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = mBinding.inflate(LayoutInflater.from(getContext()));
        mBinding.setViewModel(mViewModel);

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void observeLocationPermissions() {
        mViewModel.checkLocationPermissions().observe(requireActivity(), checkLocationPermissions -> {
            if (FusedLocationUtility.checkLocationPermissions(requireActivity())) {
                FusedLocationUtility.requestGMSLocationPermission(requireActivity(),
                        requestGMSLocationPermissionOnSuccessListener,
                        requestGMSLocationPermissionOnFailureListener);
                return;
            } else {
                FusedLocationUtility.requestPermissions(this);
            }
        });
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        FusedLocationUtility.requestGMSLocationPermission(requireActivity(),
                requestGMSLocationPermissionOnSuccessListener,
                requestGMSLocationPermissionOnFailureListener
        );
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        } else {
            navigateToPermissionFragment();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    private void navigateToPermissionFragment() {
        Navigation.findNavController(mBinding.getRoot()).navigate(R.id.action_weather_fragment_to_permission_check_fragment);
    }

    private OnSuccessListener requestGMSLocationPermissionOnSuccessListener = o -> {
    };
    private OnFailureListener requestGMSLocationPermissionOnFailureListener = e -> {
        int statusCode = ((ApiException) e).getStatusCode();
        switch (statusCode) {
            case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                ResolvableApiException rae = (ResolvableApiException) e;
                try {
                    rae.startResolutionForResult(requireActivity(), REQUEST_GMS_PERMISSION);
                } catch (IntentSender.SendIntentException ex) {
                    Log.w(TAG, "LocationService approval canceled");
                    navigateToPermissionFragment();
                }
                break;
            case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                Log.w(TAG, "No way to change setting");
                navigateToPermissionFragment();
                break;
        }
    };
}
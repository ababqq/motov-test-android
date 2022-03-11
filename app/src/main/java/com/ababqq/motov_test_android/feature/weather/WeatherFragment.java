package com.ababqq.motov_test_android.feature.weather;

import static com.ababqq.motov_test_android.utilities.Constants.REQUEST_GMS_PERMISSION;

import android.annotation.SuppressLint;
import android.content.IntentSender;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ababqq.motov_test_android.R;
import com.ababqq.motov_test_android.databinding.WeatherFragmentBinding;
import com.ababqq.motov_test_android.utilities.FusedLocationUtility;
import com.ababqq.motov_test_android.viewmodels.WeatherViewModel;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
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
    private WeatherListAdapter mAdapter;

    private LocationCallback mLocationCallback;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(WeatherViewModel.class);
        observeWeatherListVM();
        observeLocationPermissions();
        observeMyGPS();
        mViewModel.initView();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = mBinding.inflate(LayoutInflater.from(getContext()));
        mBinding.setViewModel(mViewModel);
        initList();
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initLocationCallback();
    }

    private void observeWeatherListVM() {
        mViewModel.refreshForecastItems().observe(this, aVoid -> {
            mAdapter.refresh();
        });
        mViewModel.getPage().observe(this, aVoid -> {
            mAdapter.refresh();
        });
    }

    private void initList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mAdapter = new WeatherListAdapter(requireContext());
        mAdapter.setViewModel(mViewModel);
        mBinding.weatherContentsList.setLayoutManager(layoutManager);
        mBinding.weatherContentsList.setAdapter(mAdapter);
        mBinding.weatherContentsList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() >= mAdapter.getItemCount() - 2) {
                    mViewModel.loadMorePage();
                }

            }
        });
    }

    private void observeMyGPS() {
        mViewModel.getGPSEv().observe(requireActivity(), gpsBean -> {
            Log.i(TAG, "lat:" + mViewModel.getGPS().getLat() + " lon:" + mViewModel.getGPS().getLon());
            mViewModel.loadForecast(items -> {
                mViewModel.setForecastItems().postValue(items);
                mBinding.weatherContentsList.setVisibility(View.VISIBLE);
            });

        });
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

    private void initLocationCallback() {
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
                        mViewModel.setGPS(location.getLongitude(), location.getLatitude());
                    }
                }
                LocationServices.getFusedLocationProviderClient(requireContext()).removeLocationUpdates(mLocationCallback);
            }
        };
    }

    @SuppressLint("MissingPermission")
    public void requestUpdate(LocationRequest locationRequest) {
        Log.d(TAG, "LocationRequest have been request");
        LocationServices.getFusedLocationProviderClient(requireContext())
                .requestLocationUpdates(locationRequest, mLocationCallback, null);
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
        Navigation.findNavController(mBinding.getRoot()).navigate(R.id.action_weather_fragment_to_permission_fail_fragment);
    }


    private OnSuccessListener requestGMSLocationPermissionOnSuccessListener = o -> {
        requestUpdate(FusedLocationUtility.getLocationRequest());
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
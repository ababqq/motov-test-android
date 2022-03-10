package com.ababqq.motov_test_android.feature.weather;

import static com.ababqq.motov_test_android.utilities.Constants.REQUEST_CODE_LOCATION_PERMISSION;

import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ababqq.motov_test_android.R;
import com.ababqq.motov_test_android.databinding.WeatherFragmentBinding;
import com.ababqq.motov_test_android.utilities.GPSUtility;
import com.ababqq.motov_test_android.viewmodels.WeatherViewModel;

import java.util.List;

import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class WeatherFragment extends Fragment implements EasyPermissions.PermissionCallbacks{

    private WeatherViewModel mViewModel;
    private WeatherFragmentBinding mBinding;

    public static WeatherFragment newInstance() {
        return new WeatherFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
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
        requestPermissions();
    }

    public void requestPermissions(){
        if(GPSUtility.checkLocationPermissions(requireContext())){
            return;
        }

        EasyPermissions.requestPermissions(
                this,
                "You need to accept location permissions to use this app.",
                REQUEST_CODE_LOCATION_PERMISSION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
        );
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) { }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if(EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        } else {
            Navigation.findNavController(mBinding.getRoot()).navigate(R.id.action_weather_fragment_to_permission_check_fragment);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
}
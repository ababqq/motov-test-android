package com.ababqq.motov_test_android.feature.permission_check;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ababqq.motov_test_android.R;
import com.ababqq.motov_test_android.viewmodels.PermissionCheckViewModel;

public class PermissionCheckFragment extends Fragment {

    private PermissionCheckViewModel mViewModel;

    public static PermissionCheckFragment newInstance() {
        return new PermissionCheckFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.permission_check_fragment, container, false);
    }

}
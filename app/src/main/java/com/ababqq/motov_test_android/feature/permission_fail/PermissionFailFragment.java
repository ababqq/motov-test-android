package com.ababqq.motov_test_android.feature.permission_fail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ababqq.motov_test_android.R;
import com.ababqq.motov_test_android.databinding.PermissionFailFragmentBinding;
import com.ababqq.motov_test_android.viewmodels.PermissionFailViewModel;
import com.airbnb.lottie.RenderMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PermissionFailFragment extends Fragment {

    private static final String TAG = PermissionFailFragment.class.getSimpleName();

    private PermissionFailViewModel mViewModel;
    private PermissionFailFragmentBinding mBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(PermissionFailViewModel.class);
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

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        ArrayList<String> animList = new ArrayList<String>(Arrays.asList(requireActivity().getResources().getStringArray(R.array.permission_fail_fragment_anim_list)));
        mBinding.permissionnFailLottieView.setAnimationFromUrl(animList.get(rand.nextInt(3)));
        mBinding.permissionnFailLottieView.setRenderMode(RenderMode.AUTOMATIC);
        mBinding.permissionnFailLottieView.playAnimation();
    }
}
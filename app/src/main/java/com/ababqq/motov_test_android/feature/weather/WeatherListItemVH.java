package com.ababqq.motov_test_android.feature.weather;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.ababqq.motov_test_android.databinding.WeatherItemBinding;
import com.ababqq.motov_test_android.models.HourlyVO;

class WeatherListItemVH extends RecyclerView.ViewHolder {
    private static final String TAG = WeatherListItemVH.class.getSimpleName();
    private WeatherItemBinding mBinding;

    public WeatherListItemVH(WeatherItemBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(HourlyVO item) {
        mBinding.setItem(item);
    }
}
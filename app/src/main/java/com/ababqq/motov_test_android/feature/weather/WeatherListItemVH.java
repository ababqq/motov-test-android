package com.ababqq.motov_test_android.feature.weather;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.ababqq.motov_test_android.R;
import com.ababqq.motov_test_android.databinding.WeatherItemBinding;
import com.ababqq.motov_test_android.models.HourlyVO;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.text.SimpleDateFormat;
import java.util.Date;

class WeatherListItemVH extends RecyclerView.ViewHolder {
    private static final String TAG = WeatherListItemVH.class.getSimpleName();
    private WeatherItemBinding mBinding;

    private Date date;
    private SimpleDateFormat sdf;
    private Context mContext;

    public WeatherListItemVH(WeatherItemBinding binding, Context context) {
        super(binding.getRoot());
        sdf = new java.text.SimpleDateFormat("H");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+9"));
        mBinding = binding;
        mContext = context;
    }

    public void bind(int itemPosition, HourlyVO item) {
        date = new java.util.Date(item.dt * 1000L);
        int h = Integer.parseInt(sdf.format(date));
        mBinding.setHour(h > 12
                ? ("오후 " + (h - 12) + "시")
                : ("오전 " + (h) + "시")
        );
        mBinding.setItem(item);
        Glide.with(mContext)
                .load(String.format(mContext.getString(R.string.weather_item_icon), item.weatherVO.get(0).icon))
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .fitCenter()
                .into(mBinding.weatherItemIcon);
    }
}
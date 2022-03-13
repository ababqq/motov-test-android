package com.ababqq.motov_test_android.feature.weather;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.ababqq.motov_test_android.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherListItemBindingAdapter {
    @BindingAdapter(value = {"weatherIconUrl"}, requireAll = false)
    public static void setWeatherIcon(ImageView imageView, String iconUrl) {
       Glide.with(imageView.getContext())
               .load(String.format(imageView.getContext().getString(R.string.weather_item_icon), iconUrl))
               .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
               .fitCenter()
               .into(imageView);
    }
    @BindingAdapter(value = {"weatherHumidity"}, requireAll = false)
    public static void setWeatherHumidity(TextView textView, Integer humidity) {
        textView.setText(String.format(textView.getContext().getString(R.string.weather_item_humidity), humidity));
    }
    @BindingAdapter(value = {"weatherTemp"}, requireAll = false)
    public static void setWeatherTemp(TextView textView, Double temp) {
        textView.setText(String.format(textView.getContext().getString(R.string.weather_item_temp), temp));
    }
    @BindingAdapter(value = {"weatherHour"}, requireAll = false)
    public static void setWeatherHour(TextView textView, Long dt) {
        Date date = new java.util.Date(dt * 1000L);
        SimpleDateFormat sdf;
        sdf = new java.text.SimpleDateFormat("H");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+9"));
        int h = Integer.parseInt(sdf.format(date));
        textView.setText(String.format(textView.getContext().getString(R.string.weather_item_hour), h > 12 ? "오후" : "오전", h));
    }
}

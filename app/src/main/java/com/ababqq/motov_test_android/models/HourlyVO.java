package com.ababqq.motov_test_android.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HourlyVO {

   @SerializedName("dt")
   @Expose
   public Long dt;
   @SerializedName("temp")
   @Expose
   public Double temp;
   @SerializedName("feels_like")
   @Expose
   public Double feelsLike;
   @SerializedName("pressure")
   @Expose
   public Integer pressure;
   @SerializedName("humidity")
   @Expose
   public Integer humidity;
   @SerializedName("dew_point")
   @Expose
   public Double dewPoint;
   @SerializedName("uvi")
   @Expose
   public Double uvi;
   @SerializedName("clouds")
   @Expose
   public Integer clouds;
   @SerializedName("visibility")
   @Expose
   public Integer visibility;
   @SerializedName("wind_speed")
   @Expose
   public Double windSpeed;
   @SerializedName("wind_deg")
   @Expose
   public Integer windDeg;
   @SerializedName("wind_gust")
   @Expose
   public Double windGust;
   @SerializedName("weather")
   @Expose
   public List<WeatherVO> weatherVO;
   @SerializedName("pop")
   @Expose
   public Double pop;
}
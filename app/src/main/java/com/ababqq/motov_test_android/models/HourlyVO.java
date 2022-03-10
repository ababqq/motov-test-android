package com.ababqq.motov_test_android.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HourlyVO {

   @SerializedName("dt")
   @Expose
   private Integer dt;
   @SerializedName("temp")
   @Expose
   private Double temp;
   @SerializedName("feels_like")
   @Expose
   private Double feelsLike;
   @SerializedName("pressure")
   @Expose
   private Integer pressure;
   @SerializedName("humidity")
   @Expose
   private Integer humidity;
   @SerializedName("dew_point")
   @Expose
   private Double dewPoint;
   @SerializedName("uvi")
   @Expose
   private Double uvi;
   @SerializedName("clouds")
   @Expose
   private Integer clouds;
   @SerializedName("visibility")
   @Expose
   private Integer visibility;
   @SerializedName("wind_speed")
   @Expose
   private Double windSpeed;
   @SerializedName("wind_deg")
   @Expose
   private Integer windDeg;
   @SerializedName("wind_gust")
   @Expose
   private Double windGust;
   @SerializedName("weather")
   @Expose
   private List<WeatherVO> weatherVO = null;
   @SerializedName("pop")
   @Expose
   private Double pop;

}
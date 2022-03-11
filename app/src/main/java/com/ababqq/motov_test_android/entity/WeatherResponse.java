package com.ababqq.motov_test_android.entity;

import com.ababqq.motov_test_android.models.HourlyVO;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponse {
   @SerializedName("lat")
   @Expose
   private Double lat;
   @SerializedName("lon")
   @Expose
   private Double lon;
   @SerializedName("timezone")
   @Expose
   private String timezone;
   @SerializedName("timezone_offset")
   @Expose
   private Integer timezoneOffset;
   @SerializedName("hourly")
   @Expose
   private List<HourlyVO> hourly = null;

   public Double getLat() {
      return lat;
   }

   public void setLat(Double lat) {
      this.lat = lat;
   }

   public Double getLon() {
      return lon;
   }

   public void setLon(Double lon) {
      this.lon = lon;
   }

   public String getTimezone() {
      return timezone;
   }

   public void setTimezone(String timezone) {
      this.timezone = timezone;
   }

   public Integer getTimezoneOffset() {
      return timezoneOffset;
   }

   public void setTimezoneOffset(Integer timezoneOffset) {
      this.timezoneOffset = timezoneOffset;
   }

   public List<HourlyVO> getHourly() {
      return hourly;
   }

   public void setHourly(List<HourlyVO> hourly) {
      this.hourly = hourly;
   }

}
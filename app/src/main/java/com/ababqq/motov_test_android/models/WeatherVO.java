package com.ababqq.motov_test_android.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherVO {

   @SerializedName("id")
   @Expose
   private Integer id;
   @SerializedName("main")
   @Expose
   private String main;
   @SerializedName("description")
   @Expose
   private String description;
   @SerializedName("icon")
   @Expose
   private String icon;

}
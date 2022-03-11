package com.ababqq.motov_test_android.models;

import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class WeatherVO {

   @SerializedName("id")
   @Expose
   public Integer id;
   @SerializedName("main")
   @Expose
   public String main;
   @SerializedName("description")
   @Expose
   public String description;
   @SerializedName("icon")
   @Expose
   public String icon;

}
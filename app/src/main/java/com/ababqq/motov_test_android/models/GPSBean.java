package com.ababqq.motov_test_android.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GPSBean {

    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lon")
    @Expose
    private Double lon;

    public GPSBean(double longitude, double latitude) {
        this.lon = longitude;
        this.lat = latitude;
    }

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
}

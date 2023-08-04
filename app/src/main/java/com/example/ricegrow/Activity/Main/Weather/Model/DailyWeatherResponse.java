package com.example.ricegrow.Activity.Main.Weather.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DailyWeatherResponse {
    @SerializedName("list")
    private List<DailyWeatherData> weatherResponseList;

    public List<DailyWeatherData> getWeatherResponseList() {
        return weatherResponseList;
    }

    public void setWeatherResponseList(List<DailyWeatherData> weatherResponseList) {
        this.weatherResponseList = weatherResponseList;
    }
}

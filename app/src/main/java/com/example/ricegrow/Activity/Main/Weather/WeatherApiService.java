package com.example.ricegrow.Activity.Main.Weather;
import com.example.ricegrow.Activity.Main.Weather.Model.DailyWeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiService {
    @GET("forecast/daily")
    Call<DailyWeatherResponse> getDailyWeatherData(
            @Query("lat") double latitude,
            @Query("lon") double longitude,
            @Query("appid") String apiKey,
            @Query("units") String units, // Use "metric" for Celsius or "imperial" for Fahrenheit
            @Query("cnt") int numberOfDays // Number of days for the forecast (up to 16)
    );

    @GET("forecast/daily")
    Call<DailyWeatherResponse> getDailyWeatherDataVi(
            @Query("lat") double latitude,
            @Query("lon") double longitude,
            @Query("appid") String apiKey,
            @Query("units") String units, // Use "metric" for Celsius or "imperial" for Fahrenheit
            @Query("cnt") int numberOfDays, // Number of days for the forecast (up to 16)
            @Query("lang") String lang //Language for weather response
    );
}

package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ricegrow.DatabaseFiles.Model.Weather;


@Dao
public interface WeatherDao {
    @Insert
    void insert (Weather weather);

    @Query("SELECT * FROM weather LIMIT 1")
    Weather getAll();

    @Update
    void updateWeather(Weather weather);
}

package com.hunter.ricegrow.DatabaseFiles.Model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.hunter.ricegrow.DatabaseFiles.Converter.DateConverter;

import java.time.LocalDate;

@Entity(tableName = "weather")
@TypeConverters(DateConverter.class)
public class Weather {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String unit;
    private LocalDate date;
    private double speed;
    private int humidity;
    private double temp;
    private String description;
    private String main;

    public Weather(String unit, LocalDate date, double speed, int humidity, double temp, String description, String main) {
        this.unit = unit;
        this.date = date;
        this.speed = speed;
        this.humidity = humidity;
        this.temp = temp;
        this.description = description;
        this.main = main;
    }

    @Ignore
    public Weather() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }
}

package com.example.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.ricegrow.DatabaseFiles.Converter.DateConverter;

import java.sql.Date;

@Entity(tableName = "user_crops",
        foreignKeys = {@ForeignKey(entity = Users.class, parentColumns = "id", childColumns = "user_id"),
                        @ForeignKey(entity =  Crops.class, parentColumns = "id", childColumns = "crop_id")})
@TypeConverters(DateConverter.class)
public class UserCrops {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "user_id")
    private int userId;
    @ColumnInfo(name = "crop_id")
    private int cropId;
    @ColumnInfo(name = "planting_volume")
    private double plantingVolume;
    @ColumnInfo(name = "sowing_date")
    private Date sowingDate;
    @ColumnInfo(name = "planted_area")
    private double plantedArea;
    @ColumnInfo(name = "expected_harvest_date")
    private Date expectedHarvestDate;
    @ColumnInfo(name = "growth_period")
    private int growthPeriod;

    public UserCrops(int userId, int cropId, double plantingVolume, Date sowingDate, double plantedArea, Date expectedHarvestDate, int growthPeriod) {
        this.userId = userId;
        this.cropId = cropId;
        this.plantingVolume = plantingVolume;
        this.sowingDate = sowingDate;
        this.plantedArea = plantedArea;
        this.expectedHarvestDate = expectedHarvestDate;
        this.growthPeriod = growthPeriod;
    }

    @Ignore
    public UserCrops() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCropId() {
        return cropId;
    }

    public void setCropId(int cropId) {
        this.cropId = cropId;
    }

    public double getPlantingVolume() {
        return plantingVolume;
    }

    public void setPlantingVolume(double plantingVolume) {
        this.plantingVolume = plantingVolume;
    }

    public Date getSowingDate() {
        return sowingDate;
    }

    public void setSowingDate(Date sowingDate) {
        this.sowingDate = sowingDate;
    }

    public double getPlantedArea() {
        return plantedArea;
    }

    public void setPlantedArea(double plantedArea) {
        this.plantedArea = plantedArea;
    }

    public Date getExpectedHarvestDate() {
        return expectedHarvestDate;
    }

    public void setExpectedHarvestDate(Date expectedHarvestDate) {
        this.expectedHarvestDate = expectedHarvestDate;
    }

    public int getGrowthPeriod() {
        return growthPeriod;
    }

    public void setGrowthPeriod(int growthPeriod) {
        this.growthPeriod = growthPeriod;
    }

    @Override
    public String toString() {
        return "UserCrops{" +
                "id=" + id +
                ", user_id=" + userId +
                ", crop_id=" + cropId +
                ", planting_volume=" + plantingVolume +
                ", planted_area=" + plantedArea +
                '}';
    }
}

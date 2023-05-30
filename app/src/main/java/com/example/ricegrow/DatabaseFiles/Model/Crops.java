package com.example.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "crops")
public class Crops {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String description;
    @ColumnInfo(name = "growth_period")
    private int growthPeriod;
    @ColumnInfo(name = "selling_price")
    private double sellingPrice;
    @ColumnInfo(name = "salt_tolerance")
    private double saltTolerance;
    @ColumnInfo(name = "crop_image")
    private String cropImage;

    public Crops(String name, String description, int growthPeriod, double sellingPrice, double saltTolerance, String cropImage) {
        this.name = name;
        this.description = description;
        this.growthPeriod = growthPeriod;
        this.sellingPrice = sellingPrice;
        this.saltTolerance = saltTolerance;
        this.cropImage = cropImage;
    }

    @Ignore
    public Crops() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGrowthPeriod() {
        return growthPeriod;
    }

    public void setGrowthPeriod(int growthPeriod) {
        this.growthPeriod = growthPeriod;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getSaltTolerance() {
        return saltTolerance;
    }

    public void setSaltTolerance(double saltTolerance) {
        this.saltTolerance = saltTolerance;
    }

    public String getCropImage() {
        return cropImage;
    }

    public void setCropImage(String cropImage) {
        this.cropImage = cropImage;
    }

    @Override
    public String toString() {
        return "Crops{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", growth_period=" + growthPeriod +
                ", selling_price=" + sellingPrice +
                ", optimal_temperature=" + saltTolerance +
                ", crop_image='" + cropImage + '\'' +
                '}';
    }
}

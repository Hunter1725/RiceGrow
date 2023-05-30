package com.example.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "pesticides")
public class Pesticides {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String manufacturer;
    private String composition;
    @ColumnInfo(name = "usage_instructions")
    private String usageInstructions;
    @ColumnInfo(name = "pesticide_per_bottle")
    private double pesticidePerBottle;
    @ColumnInfo(name = "water_per_hectare")
    private double waterPerHectare;
    @ColumnInfo(name = "pesticide_image")
    private String pesticideImage;

    public Pesticides(String name, String manufacturer, String composition, String usageInstructions, double pesticidePerBottle, double waterPerHectare, String pesticideImage) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.composition = composition;
        this.usageInstructions = usageInstructions;
        this.pesticidePerBottle = pesticidePerBottle;
        this.waterPerHectare = waterPerHectare;
        this.pesticideImage = pesticideImage;
    }

    @Ignore
    public Pesticides() {
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getUsageInstructions() {
        return usageInstructions;
    }

    public void setUsageInstructions(String usageInstructions) {
        this.usageInstructions = usageInstructions;
    }

    public double getWaterPerHectare() {
        return waterPerHectare;
    }

    public void setWaterPerHectare(double waterPerHectare) {
        this.waterPerHectare = waterPerHectare;
    }

    public double getPesticidePerBottle() {
        return pesticidePerBottle;
    }

    public void setPesticidePerBottle(double pesticidePerBottle) {
        this.pesticidePerBottle = pesticidePerBottle;
    }

    public String getPesticideImage() {
        return pesticideImage;
    }

    public void setPesticideImage(String pesticideImage) {
        this.pesticideImage = pesticideImage;
    }
}

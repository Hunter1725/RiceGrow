package com.example.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "fertilizers")
public class Fertilizers {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String manufacturer;
    private String composition;
    @ColumnInfo(name = "usage_instructions")
    private String usageInstructions;
    @ColumnInfo(name = "recommended_usage")
    private double recommendedUsage;
    @ColumnInfo(name = "fert_image")
    private String fertImage;

    public Fertilizers(String name, String manufacturer, String composition, String usageInstructions, double recommendedUsage, String fertImage) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.composition = composition;
        this.usageInstructions = usageInstructions;
        this.recommendedUsage = recommendedUsage;
        this.fertImage = fertImage;
    }

    @Ignore
    public Fertilizers() {
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

    public double getRecommendedUsage() {
        return recommendedUsage;
    }

    public void setRecommendedUsage(double recommendedUsage) {
        this.recommendedUsage = recommendedUsage;
    }

    public String getFertImage() {
        return fertImage;
    }

    public void setFertImage(String fertImage) {
        this.fertImage = fertImage;
    }
}

package com.example.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "pests")
public class Pests {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String lifecycle;
    private String symptoms;
    private String description;
    @ColumnInfo(name = "control_methods")
    private String controlMethods;
    @ColumnInfo(name = "pest_image")
    private String pestImage;

    public Pests(String name, String lifecycle, String symptoms, String description, String controlMethods, String pestImage) {
        this.name = name;
        this.lifecycle = lifecycle;
        this.symptoms = symptoms;
        this.description = description;
        this.controlMethods = controlMethods;
        this.pestImage = pestImage;
    }

    @Ignore
    public Pests() {
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

    public String getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(String lifecycle) {
        this.lifecycle = lifecycle;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getControlMethods() {
        return controlMethods;
    }

    public void setControlMethods(String controlMethods) {
        this.controlMethods = controlMethods;
    }

    public String getPestImage() {
        return pestImage;
    }

    public void setPestImage(String pestImage) {
        this.pestImage = pestImage;
    }

}

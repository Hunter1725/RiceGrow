package com.example.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "diseases")
public class Diseases {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String symptoms;
    private String description;
    @ColumnInfo(name = "prevention_methods")
    private String preventionMethods;
    @ColumnInfo(name = "disease_image")
    private String diseaseImage;

    public Diseases(String name, String symptoms, String description, String preventionMethods, String diseaseImage) {
        this.name = name;
        this.symptoms = symptoms;
        this.description = description;
        this.preventionMethods = preventionMethods;
        this.diseaseImage = diseaseImage;
    }

    @Ignore
    public Diseases() {
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

    public String getPreventionMethods() {
        return preventionMethods;
    }

    public void setPreventionMethods(String preventionMethods) {
        this.preventionMethods = preventionMethods;
    }

    public String getDiseaseImage() {
        return diseaseImage;
    }

    public void setDiseaseImage(String diseaseImage) {
        this.diseaseImage = diseaseImage;
    }
}

package com.example.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

@Entity(tableName = "activity_pesticides",
        primaryKeys = {"activity_id", "pesticide_id"},
        foreignKeys = {@ForeignKey(entity = Activities.class, parentColumns = "id", childColumns = "activity_id"),
                        @ForeignKey(entity = Pesticides.class, parentColumns = "id", childColumns = "pesticide_id")})
public class ActivityPesticides {
    @ColumnInfo(name = "activity_id")
    private int activityId;
    @ColumnInfo(name = "pesticide_id")
    private int pesticideId;
    private double dosage;
    @ColumnInfo(name = "application_frequency")
    private String applicationFrequency;

    public ActivityPesticides(int activityId, int pesticideId, double dosage, String applicationFrequency) {
        this.activityId = activityId;
        this.pesticideId = pesticideId;
        this.dosage = dosage;
        this.applicationFrequency = applicationFrequency;
    }

    @Ignore
    public ActivityPesticides() {
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getPesticideId() {
        return pesticideId;
    }

    public void setPesticideId(int pesticideId) {
        this.pesticideId = pesticideId;
    }

    public double getDosage() {
        return dosage;
    }

    public void setDosage(double dosage) {
        this.dosage = dosage;
    }

    public String getApplicationFrequency() {
        return applicationFrequency;
    }

    public void setApplicationFrequency(String applicationFrequency) {
        this.applicationFrequency = applicationFrequency;
    }
}

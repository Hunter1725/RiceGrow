package com.example.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

@Entity(tableName = "activity_fertilizers",
        primaryKeys = {"activity_id", "fertilizer_id"},
        foreignKeys = {@ForeignKey(entity = Activities.class, parentColumns = "id", childColumns = "activity_id"),
                @ForeignKey(entity = Fertilizers.class, parentColumns = "id", childColumns = "fertilizer_id")})
public class ActivityFertilizers {
    @ColumnInfo(name = "activity_id")
    private int activityId;
    @ColumnInfo(name = "fertilizer_id")
    private int fertilizerId;
    private double dosage;
    @ColumnInfo(name = "application_frequency")
    private String applicationFrequency;

    public ActivityFertilizers(int activityId, int fertilizerId, double dosage, String applicationFrequency) {
        this.activityId = activityId;
        this.fertilizerId = fertilizerId;
        this.dosage = dosage;
        this.applicationFrequency = applicationFrequency;
    }

    @Ignore
    public ActivityFertilizers() {
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getFertilizerId() {
        return fertilizerId;
    }

    public void setFertilizerId(int fertilizerId) {
        this.fertilizerId = fertilizerId;
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

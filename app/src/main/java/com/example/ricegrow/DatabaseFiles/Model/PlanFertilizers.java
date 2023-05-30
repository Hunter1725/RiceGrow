package com.example.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

@Entity(tableName = "plan_fertilizers",
        primaryKeys = {"fertilizer_id", "plan_activity_id"},
        foreignKeys = {@ForeignKey(entity = PlanActivities.class, parentColumns = "id", childColumns = "plan_activity_id"),
                @ForeignKey(entity = Fertilizers.class, parentColumns = "id", childColumns = "fertilizer_id")})
public class PlanFertilizers {
    @ColumnInfo(name = "plan_activity_id")
    private int planActivityId;
    @ColumnInfo(name = "fertilizer_id")
    private int fertilizerId;
    private double dosage;
    @ColumnInfo(name = "application_frequency")
    private String applicationFrequency;

    public PlanFertilizers(int planActivityId, int fertilizerId, double dosage, String applicationFrequency) {
        this.planActivityId = planActivityId;
        this.fertilizerId = fertilizerId;
        this.dosage = dosage;
        this.applicationFrequency = applicationFrequency;
    }

    @Ignore
    public PlanFertilizers() {
    }

    public int getPlanActivityId() {
        return planActivityId;
    }

    public void setPlanActivityId(int planActivityId) {
        this.planActivityId = planActivityId;
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

package com.example.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

@Entity(tableName = "plan_pesticides",
        primaryKeys = {"pesticide_id", "plan_activity_id"},
        foreignKeys = {@ForeignKey(entity = PlanActivities.class, parentColumns = "id", childColumns = "plan_activity_id"),
                @ForeignKey(entity = Pesticides.class, parentColumns = "id", childColumns = "pesticide_id")})
public class PlanPesticides {
    @ColumnInfo(name = "plan_activity_id")
    private int planActivityId;
    @ColumnInfo(name = "pesticide_id")
    private int pesticideId;
    private double dosage;
    @ColumnInfo(name = "application_frequency")
    private String applicationFrequency;

    public PlanPesticides(int planActivityId, int pesticideId, double dosage, String applicationFrequency) {
        this.planActivityId = planActivityId;
        this.pesticideId = pesticideId;
        this.dosage = dosage;
        this.applicationFrequency = applicationFrequency;
    }

    @Ignore
    public PlanPesticides() {
    }

    public int getPlanActivityId() {
        return planActivityId;
    }

    public void setPlanActivityId(int planActivityId) {
        this.planActivityId = planActivityId;
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

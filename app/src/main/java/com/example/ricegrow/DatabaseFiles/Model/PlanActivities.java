package com.example.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "plan_activities",
        foreignKeys = {@ForeignKey(entity = PlanStages.class, parentColumns = "id", childColumns = "plan_stage_id")})
public class PlanActivities {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "plan_stage_id")
    private int planStageId;
    private String name;
    private String description;
    private int duration;

    public PlanActivities(int planStageId, String name, String description, int duration) {
        this.planStageId = planStageId;
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    @Ignore
    public PlanActivities() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlanStageId() {
        return planStageId;
    }

    public void setPlanStageId(int planStageId) {
        this.planStageId = planStageId;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

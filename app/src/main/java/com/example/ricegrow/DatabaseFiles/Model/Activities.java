package com.example.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "activities",
        foreignKeys = {@ForeignKey(entity = Stages.class, parentColumns = "id", childColumns = "stage_id")})
public class Activities {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "stage_id")
    private int stageId;
    private String name;
    private String description;
    private int duration;
    @ColumnInfo(name = "activity_image")
    private String activityImage;

    public Activities(int stageId, String name, String description, int duration, String activityImage) {
        this.stageId = stageId;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.activityImage = activityImage;
    }

    @Ignore
    public Activities() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStageId() {
        return stageId;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActivityImage() {
        return activityImage;
    }

    public void setActivityImage(String activityImage) {
        this.activityImage = activityImage;
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

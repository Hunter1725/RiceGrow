package com.example.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "stages",
        foreignKeys = {@ForeignKey(entity = Crops.class, parentColumns = "id", childColumns = "crop_id")})
public class Stages {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "crop_id")
    private int cropId;
    private String name;
    private int duration;
    private int order;
    @ColumnInfo(name = "start_date")
    private String startDate;
    @ColumnInfo(name = "end_date")
    private String endDate;
    @ColumnInfo(name = "stage_image")
    private String stageImage;

    public Stages(int cropId, String name, int duration, int order, String startDate, String endDate, String stageImage) {
        this.cropId = cropId;
        this.name = name;
        this.duration = duration;
        this.order = order;
        this.startDate = startDate;
        this.endDate = endDate;
        this.stageImage = stageImage;
    }

    @Ignore
    public Stages() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCropId() {
        return cropId;
    }

    public void setCropId(int cropId) {
        this.cropId = cropId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStageImage() {
        return stageImage;
    }

    public void setStageImage(String stageImage) {
        this.stageImage = stageImage;
    }
}

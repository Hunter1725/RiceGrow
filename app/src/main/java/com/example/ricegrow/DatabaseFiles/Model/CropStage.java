package com.example.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

@Entity(tableName = "crop_stage",
        primaryKeys = {"crop_id", "stage_id"},
        foreignKeys = {@ForeignKey(entity = Crops.class, parentColumns = "id", childColumns = "crop_id"),
                @ForeignKey(entity = Stages.class, parentColumns = "id", childColumns = "stage_id")})
public class CropStage {

    @ColumnInfo(name = "crop_id")
    private int cropId;
    @ColumnInfo(name = "stage_id")
    private int stageId;
    private int duration;
    @ColumnInfo(name = "start_date")
    private String startDate;
    @ColumnInfo(name = "end_date")
    private String endDate;

    public CropStage(int cropId, int stageId, int duration, String startDate, String endDate) {
        this.cropId = cropId;
        this.stageId = stageId;
        this.duration = duration;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Ignore
    public CropStage() {
    }

    public int getCropId() {
        return cropId;
    }

    public void setCropId(int cropId) {
        this.cropId = cropId;
    }

    public int getStageId() {
        return stageId;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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
}

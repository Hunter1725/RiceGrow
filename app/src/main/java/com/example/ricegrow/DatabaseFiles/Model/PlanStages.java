package com.example.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "plan_stages",
        foreignKeys = {@ForeignKey(entity = UserCrops.class, parentColumns = "id", childColumns = "user_crop_id"),
                @ForeignKey(entity =  Stages.class, parentColumns = "id", childColumns = "stage_id")})
public class PlanStages {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "user_crop_id")
    private int userCropId;
    @ColumnInfo(name = "stage_id")
    private int stageId;
    @ColumnInfo(name = "start_date")
    private String startDate;
    @ColumnInfo(name = "end_date")
    private String endDate;

    public PlanStages(int userCropId, int stageId, String startDate, String endDate) {
        this.userCropId = userCropId;
        this.stageId = stageId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Ignore
    public PlanStages() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserCropId() {
        return userCropId;
    }

    public void setUserCropId(int userCropId) {
        this.userCropId = userCropId;
    }

    public int getStageId() {
        return stageId;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
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

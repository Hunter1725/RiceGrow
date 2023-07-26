package com.example.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.ricegrow.DatabaseFiles.Converter.DateConverter;

import java.time.LocalDate;

@Entity(tableName = "plan_stages",
        foreignKeys = {@ForeignKey(entity = UserCrops.class, parentColumns = "id", childColumns = "user_crop_id", onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity =  Stages.class, parentColumns = "id", childColumns = "stage_id")})
@TypeConverters(DateConverter.class)
public class PlanStages {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "user_crop_id")
    private int userCropId;
    @ColumnInfo(name = "stage_id")
    private int stageId;
    @ColumnInfo(name = "start_date")
    private LocalDate startDate;
    @ColumnInfo(name = "end_date")
    private LocalDate endDate;

    public PlanStages(int userCropId, int stageId, LocalDate startDate, LocalDate endDate) {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}

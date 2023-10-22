package com.hunter.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.hunter.ricegrow.DatabaseFiles.Converter.DateConverter;

import java.time.LocalDate;

@Entity(tableName = "plan_activities",
        foreignKeys = {@ForeignKey(entity = PlanStages.class, parentColumns = "id", childColumns = "plan_stage_id", onDelete = ForeignKey.CASCADE),
                        @ForeignKey(entity =  Activities.class, parentColumns = "id", childColumns = "activity_id")})
@TypeConverters(DateConverter.class)
public class PlanActivities {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "plan_stage_id")
    private int planStageId;
    @ColumnInfo(name = "activity_id")
    private int activityId;
    @ColumnInfo(name = "start_date")
    private LocalDate startDate;
    @ColumnInfo(name = "end_date")
    private LocalDate endDate;

    public PlanActivities(int planStageId, int activityId, LocalDate startDate, LocalDate endDate) {
        this.planStageId = planStageId;
        this.activityId = activityId;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }
}

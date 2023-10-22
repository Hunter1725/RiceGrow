package com.hunter.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.hunter.ricegrow.DatabaseFiles.Converter.DateConverter;

import java.time.LocalDate;

@Entity(tableName = "notes",
        foreignKeys = {@ForeignKey(entity = PlanStages.class, parentColumns = "id", childColumns = "plan_stage_id", onDelete = ForeignKey.CASCADE)})
@TypeConverters(DateConverter.class)
public class Notes {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "plan_stage_id")
    private int planStageId;
    private LocalDate date;
    private String content;

    public Notes(int planStageId, LocalDate date, String content) {
        this.planStageId = planStageId;
        this.date = date;
        this.content = content;
    }

    @Ignore
    public Notes() {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

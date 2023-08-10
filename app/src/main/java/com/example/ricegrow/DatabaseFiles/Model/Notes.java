package com.example.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.ricegrow.DatabaseFiles.Converter.DateConverter;

import java.time.LocalDate;

@Entity(tableName = "notes",
        foreignKeys = {@ForeignKey(entity = PlanActivities.class, parentColumns = "id", childColumns = "plan_activity_id", onDelete = ForeignKey.CASCADE)})
@TypeConverters(DateConverter.class)
public class Notes {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "plan_activity_id")
    private int planActivityId;
    private LocalDate date;
    private String content;

    public Notes(int planActivityId, LocalDate date, String content) {
        this.planActivityId = planActivityId;
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

    public int getPlanActivityId() {
        return planActivityId;
    }

    public void setPlanActivityId(int planActivityId) {
        this.planActivityId = planActivityId;
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

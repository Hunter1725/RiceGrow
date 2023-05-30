package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.ricegrow.DatabaseFiles.Model.PlanActivities;

@Dao
public interface PlanActivityDao {
    @Insert
    void insert (PlanActivities planActivities);
}

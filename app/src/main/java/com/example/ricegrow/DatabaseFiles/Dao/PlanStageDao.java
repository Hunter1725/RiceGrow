package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.ricegrow.DatabaseFiles.Model.PlanStages;

@Dao
public interface PlanStageDao {
    @Insert
    void insert (PlanStages planStages);
}

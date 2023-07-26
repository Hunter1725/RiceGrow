package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ricegrow.DatabaseFiles.Model.PlanActivities;
import com.example.ricegrow.DatabaseFiles.Model.PlanStages;

import java.util.List;

@Dao
public interface PlanActivityDao {
    @Insert
    void insert (PlanActivities planActivities);

    @Query("SELECT * FROM plan_activities WHERE plan_stage_id =:id")
    List<PlanActivities> getAllPlanActivitiesByPlanStageId(int id);
}

package com.hunter.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.hunter.ricegrow.DatabaseFiles.Model.PlanActivities;

import java.util.List;

@Dao
public interface PlanActivityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert (PlanActivities planActivities);

    @Query("SELECT * FROM plan_activities WHERE plan_stage_id =:id")
    List<PlanActivities> getAllPlanActivitiesByPlanStageId(int id);
}

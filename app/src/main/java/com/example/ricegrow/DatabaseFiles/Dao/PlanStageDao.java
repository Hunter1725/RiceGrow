package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.ricegrow.DatabaseFiles.Model.PlanStages;
import com.example.ricegrow.DatabaseFiles.Model.Stages;
import com.example.ricegrow.DatabaseFiles.Model.UserCrops;

import java.util.List;

@Dao
public interface PlanStageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert (PlanStages planStages);

    @Query("SELECT * FROM plan_stages WHERE user_crop_id =:id")
    List<PlanStages> getAllPlanStageByUserCropId(int id);

    @Query("SELECT * FROM plan_stages WHERE id =:id")
    PlanStages getPlanStagesById(int id);

    @Query("DELETE FROM plan_stages WHERE user_crop_id =:id")
    void deletePlanStageByUserCropId(int id);
}

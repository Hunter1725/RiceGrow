package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ricegrow.DatabaseFiles.Model.PlanStages;
import com.example.ricegrow.DatabaseFiles.Model.Stages;

import java.util.List;

@Dao
public interface PlanStageDao {
    @Insert
    void insert (PlanStages planStages);

    @Query("SELECT * FROM plan_stages WHERE user_crop_id =:id")
    List<PlanStages> getAllPlanStageByUserCropId(int id);
}

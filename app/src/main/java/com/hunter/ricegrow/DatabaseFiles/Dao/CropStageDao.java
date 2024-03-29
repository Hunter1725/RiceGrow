package com.hunter.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.hunter.ricegrow.DatabaseFiles.Model.CropStage;

import java.util.List;

@Dao
public interface CropStageDao {
    @Insert
    void insert (CropStage cropStage);

    @Query("SELECT * FROM crop_stage WHERE stage_id =:id LIMIT 1")
    CropStage getFirstCropStageByStageId(int id);

    @Query("SELECT * FROM crop_stage WHERE stage_id =:id")
    List<CropStage> getCropStageByStageId(int id);

    @Query("SELECT * FROM crop_stage WHERE stage_id =:stageId AND crop_id =:cropId")
    CropStage getCropStageByStageIdAndCropId(int stageId, int cropId);
}

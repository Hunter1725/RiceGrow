package com.hunter.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.hunter.ricegrow.DatabaseFiles.Model.DiseasesStages;

@Dao
public interface DiseaseStageDao {
    @Insert
    void insert (DiseasesStages diseasesStages);
}

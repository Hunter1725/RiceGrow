package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.ricegrow.DatabaseFiles.Model.DiseasesStages;

@Dao
public interface DiseaseStageDao {
    @Insert
    void insert (DiseasesStages diseasesStages);
}

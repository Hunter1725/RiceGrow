package com.hunter.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.hunter.ricegrow.DatabaseFiles.Model.CropDiseases;

@Dao
public interface CropDiseaseDao {
    @Insert
    void insert (CropDiseases cropDiseases);
}

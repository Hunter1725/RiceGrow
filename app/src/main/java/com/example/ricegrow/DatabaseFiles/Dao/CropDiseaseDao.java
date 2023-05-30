package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.ricegrow.DatabaseFiles.Model.CropDiseases;

@Dao
public interface CropDiseaseDao {
    @Insert
    void insert (CropDiseases cropDiseases);
}

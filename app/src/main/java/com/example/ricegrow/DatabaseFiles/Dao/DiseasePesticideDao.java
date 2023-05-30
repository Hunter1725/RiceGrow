package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.ricegrow.DatabaseFiles.Model.DiseasesPesticides;

@Dao
public interface DiseasePesticideDao {
    @Insert
    void insert (DiseasesPesticides diseasesPesticides);
}

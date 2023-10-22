package com.hunter.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.hunter.ricegrow.DatabaseFiles.Model.DiseasesPesticides;

@Dao
public interface DiseasePesticideDao {
    @Insert
    void insert (DiseasesPesticides diseasesPesticides);
}

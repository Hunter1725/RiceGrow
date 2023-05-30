package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.ricegrow.DatabaseFiles.Model.CropPests;

@Dao
public interface CropPestDao {
    @Insert
    void insert (CropPests cropPests);
}

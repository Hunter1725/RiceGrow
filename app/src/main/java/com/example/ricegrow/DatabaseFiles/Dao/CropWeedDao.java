package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.ricegrow.DatabaseFiles.Model.CropWeeds;

@Dao
public interface CropWeedDao {
    @Insert
    void insert (CropWeeds cropWeeds);
}

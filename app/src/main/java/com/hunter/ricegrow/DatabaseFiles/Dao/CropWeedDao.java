package com.hunter.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.hunter.ricegrow.DatabaseFiles.Model.CropWeeds;

@Dao
public interface CropWeedDao {
    @Insert
    void insert (CropWeeds cropWeeds);
}

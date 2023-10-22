package com.hunter.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.hunter.ricegrow.DatabaseFiles.Model.CropDeftox;


@Dao
public interface CropDeftoxDao {
    @Insert
    void insert(CropDeftox cropDeftox);
}

package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.ricegrow.DatabaseFiles.Model.CropDeftox;


@Dao
public interface CropDeftoxDao {
    @Insert
    void insert(CropDeftox cropDeftox);
}

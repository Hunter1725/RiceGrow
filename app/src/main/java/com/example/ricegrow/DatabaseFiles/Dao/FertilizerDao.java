package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.ricegrow.DatabaseFiles.Model.Fertilizers;

@Dao
public interface FertilizerDao {
    @Insert
    void insert (Fertilizers fertilizers);
}

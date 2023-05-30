package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.ricegrow.DatabaseFiles.Model.Stages;

@Dao
public interface StageDao {
    @Insert
    void insert (Stages stages);
}

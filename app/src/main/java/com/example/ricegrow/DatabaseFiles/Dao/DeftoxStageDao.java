package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.ricegrow.DatabaseFiles.Model.DeftoxStage;

@Dao
public interface DeftoxStageDao {
    @Insert
    void insert(DeftoxStage deftoxStage);
}

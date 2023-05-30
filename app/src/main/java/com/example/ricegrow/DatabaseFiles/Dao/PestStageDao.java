package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.ricegrow.DatabaseFiles.Model.PestsStages;

@Dao
public interface PestStageDao {
    @Insert
    void insert (PestsStages pestsStages);
}

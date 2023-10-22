package com.hunter.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.hunter.ricegrow.DatabaseFiles.Model.PestsStages;

@Dao
public interface PestStageDao {
    @Insert
    void insert (PestsStages pestsStages);
}

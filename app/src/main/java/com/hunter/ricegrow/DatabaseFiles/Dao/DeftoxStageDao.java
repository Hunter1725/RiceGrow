package com.hunter.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.hunter.ricegrow.DatabaseFiles.Model.DeftoxStage;

@Dao
public interface DeftoxStageDao {
    @Insert
    void insert(DeftoxStage deftoxStage);
}

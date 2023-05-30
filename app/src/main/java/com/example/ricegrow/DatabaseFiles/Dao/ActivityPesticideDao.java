package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.ricegrow.DatabaseFiles.Model.ActivityPesticides;

@Dao
public interface ActivityPesticideDao {
    @Insert
    void insert (ActivityPesticides activityPesticides);
}

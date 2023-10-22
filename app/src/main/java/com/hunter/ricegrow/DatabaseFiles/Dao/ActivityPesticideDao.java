package com.hunter.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.hunter.ricegrow.DatabaseFiles.Model.ActivityPesticides;

@Dao
public interface ActivityPesticideDao {
    @Insert
    void insert (ActivityPesticides activityPesticides);
}

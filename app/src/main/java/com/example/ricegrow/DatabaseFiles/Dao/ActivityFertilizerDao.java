package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.ricegrow.DatabaseFiles.Model.ActivityFertilizers;

@Dao
public interface ActivityFertilizerDao {
    @Insert
    void insert (ActivityFertilizers activityFertilizers);
}

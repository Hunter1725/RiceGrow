package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.ricegrow.DatabaseFiles.Model.PlanFertilizers;

@Dao
public interface PlanFertilizerDao {
    @Insert
    void insert (PlanFertilizers planFertilizers);
}

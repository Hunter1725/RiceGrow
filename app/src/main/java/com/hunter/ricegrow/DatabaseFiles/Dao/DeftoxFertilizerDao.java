package com.hunter.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.hunter.ricegrow.DatabaseFiles.Model.DeftoxFertilizer;

@Dao
public interface DeftoxFertilizerDao {
    @Insert
    void insert(DeftoxFertilizer deftoxFertilizer);
}

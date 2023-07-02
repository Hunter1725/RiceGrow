package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ricegrow.DatabaseFiles.Model.FertilizerCalculating;

@Dao
public interface FertilizerCalculatingDao {
    @Insert
    void insert (FertilizerCalculating fertilizerCalculating);

    @Query("SELECT * FROM fertilizer_calculating LIMIT 1")
    FertilizerCalculating getAll();

    @Update
    void updateFertilizerCalculating(FertilizerCalculating fertilizerCalculating);
}

package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.ricegrow.DatabaseFiles.Model.PlanPesticides;

@Dao
public interface PlanPesticideDao {
    @Insert
    void insert (PlanPesticides planPesticides);
}

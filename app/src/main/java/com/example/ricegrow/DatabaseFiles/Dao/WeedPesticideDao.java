package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.ricegrow.DatabaseFiles.Model.WeedsPesticides;

@Dao
public interface WeedPesticideDao {
    @Insert
    void insert (WeedsPesticides weedsPesticides);
}

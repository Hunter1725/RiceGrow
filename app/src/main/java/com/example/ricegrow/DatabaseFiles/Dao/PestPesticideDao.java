package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.ricegrow.DatabaseFiles.Model.PestsPesticides;

@Dao
public interface PestPesticideDao {
    @Insert
    void insert (PestsPesticides pestsPesticides);
}

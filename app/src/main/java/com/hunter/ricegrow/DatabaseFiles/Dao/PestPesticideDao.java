package com.hunter.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.hunter.ricegrow.DatabaseFiles.Model.PestsPesticides;

@Dao
public interface PestPesticideDao {
    @Insert
    void insert (PestsPesticides pestsPesticides);
}

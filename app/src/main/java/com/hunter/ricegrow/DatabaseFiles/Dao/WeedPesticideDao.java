package com.hunter.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.hunter.ricegrow.DatabaseFiles.Model.WeedsPesticides;

@Dao
public interface WeedPesticideDao {
    @Insert
    void insert (WeedsPesticides weedsPesticides);
}

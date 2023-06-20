package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ricegrow.DatabaseFiles.Model.Pests;
import com.example.ricegrow.DatabaseFiles.Model.PestsPesticides;

import java.util.List;

@Dao
public interface PestPesticideDao {
    @Insert
    void insert (PestsPesticides pestsPesticides);
}

package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ricegrow.DatabaseFiles.Model.Stages;

@Dao
public interface StageDao {
    @Insert
    void insert (Stages stages);

    @Query("SELECT id FROM stages WHERE name =:name")
    int getIdByName (String name);
}

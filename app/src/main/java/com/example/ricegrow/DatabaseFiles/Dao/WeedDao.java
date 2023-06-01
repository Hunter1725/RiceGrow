package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ricegrow.DatabaseFiles.Model.Weeds;

@Dao
public interface WeedDao {
    @Insert
    void insert (Weeds weeds);

    @Query("SELECT id FROM weeds WHERE name =:name")
    int getIdByName (String name);
}

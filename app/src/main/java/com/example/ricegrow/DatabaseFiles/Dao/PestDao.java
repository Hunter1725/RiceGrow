package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ricegrow.DatabaseFiles.Model.Pests;

@Dao
public interface PestDao {
    @Insert
    void insert (Pests pests);

    @Query("SELECT id FROM pests WHERE name =:name")
    int getIdByName (String name);
}

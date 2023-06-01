package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ricegrow.DatabaseFiles.Model.Activities;

@Dao
public interface ActivityDao {
    @Insert
    void insert (Activities activities);

    @Query("SELECT id FROM activities WHERE name =:name")
    int getIdByName (String name);
}

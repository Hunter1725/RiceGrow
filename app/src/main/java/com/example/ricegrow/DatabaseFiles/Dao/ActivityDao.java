package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.ricegrow.DatabaseFiles.Model.Activities;

@Dao
public interface ActivityDao {
    @Insert
    void insert (Activities activities);
}

package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ricegrow.DatabaseFiles.Model.Crops;

@Dao
public interface CropDao {
    @Insert
    void insert (Crops crops);

    @Query("SELECT id FROM crops WHERE name =:name")
    int getIdByName (String name);

}

package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ricegrow.DatabaseFiles.Model.Crops;

import java.util.List;

@Dao
public interface CropDao {
    @Insert
    void insert (Crops crops);

    @Query("SELECT id FROM crops WHERE name =:name")
    int getIdByName (String name);

    @Query("SELECT * FROM crops WHERE id =:id")
    Crops getCropById (int id);

    @Query("SELECT name FROM crops")
    List<String> getAllCropNames();

    @Query("SELECT * FROM crops")
    List<Crops> getAllCrops();

    @Query("SELECT * FROM crops WHERE name LIKE :name")
    List<Crops> getCropsByName(String name);

}

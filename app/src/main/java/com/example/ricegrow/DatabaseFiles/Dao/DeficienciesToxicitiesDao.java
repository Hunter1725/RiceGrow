package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ricegrow.DatabaseFiles.Model.DeficienciesToxicities;
import com.example.ricegrow.DatabaseFiles.Model.Diseases;

import java.util.List;

@Dao
public interface DeficienciesToxicitiesDao {
    @Insert
    void insert(DeficienciesToxicities deficienciesToxicities);

    @Query("SELECT id FROM deficiencies_toxicities WHERE name =:name")
    int getIdByName (String name);

    @Query("SELECT * FROM deficiencies_toxicities")
    List<DeficienciesToxicities> getAllDeftoxs();

    @Query("SELECT * FROM deficiencies_toxicities WHERE name LIKE :name")
    List<DeficienciesToxicities> getDeftoxByName(String name);
}

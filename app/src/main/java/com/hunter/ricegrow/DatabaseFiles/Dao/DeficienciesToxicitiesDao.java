package com.hunter.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.hunter.ricegrow.DatabaseFiles.Model.DeficienciesToxicities;

import java.util.List;

@Dao
public interface DeficienciesToxicitiesDao {
    @Insert
    void insert(DeficienciesToxicities deficienciesToxicities);

    @Query("SELECT id FROM deficiencies_toxicities WHERE nameEn =:name")
    int getIdByName (String name);

    @Query("SELECT * FROM deficiencies_toxicities")
    List<DeficienciesToxicities> getAllDeftoxs();

    @Query("SELECT * FROM deficiencies_toxicities WHERE nameEn LIKE :name OR nameVi LIKE :name")
    List<DeficienciesToxicities> getDeftoxByName(String name);
}

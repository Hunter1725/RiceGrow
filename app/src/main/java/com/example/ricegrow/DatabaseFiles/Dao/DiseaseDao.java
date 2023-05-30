package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ricegrow.DatabaseFiles.Model.Diseases;

@Dao
public interface DiseaseDao {
    @Insert
    void insert (Diseases diseases);

    @Query("SELECT id FROM diseases WHERE name =:name")
    int getIdByName (String name);
}

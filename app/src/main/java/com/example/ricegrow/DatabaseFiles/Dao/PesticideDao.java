package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ricegrow.DatabaseFiles.Model.Pesticides;

@Dao
public interface PesticideDao {
    @Insert
    void insert (Pesticides pesticides);

    @Query("SELECT id FROM pesticides WHERE name =:name")
    int getIdByName (String name);
}

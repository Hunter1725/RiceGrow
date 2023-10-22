package com.hunter.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.hunter.ricegrow.DatabaseFiles.Model.Weeds;

import java.util.List;

@Dao
public interface WeedDao {
    @Insert
    void insert (Weeds weeds);

    @Query("SELECT id FROM weeds WHERE nameEn =:name")
    int getIdByName (String name);

    @Query("SELECT * FROM weeds")
    List<Weeds> getAllWeeds();

    @Query("SELECT * FROM weeds WHERE nameEn LIKE :name OR nameVi LIKE :name")
    List<Weeds> getWeedsByName(String name);

    @Query("SELECT * FROM weeds WHERE id IN (SELECT weed_id FROM weeds_pesticides WHERE pesticide_id = :pesticideId)")
    List<Weeds> getWeedByPesticideId (int pesticideId);

    @Query("SELECT * FROM weeds WHERE id IN (SELECT weed_id FROM crop_weeds WHERE crop_id = :cropId)")
    List<Weeds> getWeedByCropId (int cropId);
}

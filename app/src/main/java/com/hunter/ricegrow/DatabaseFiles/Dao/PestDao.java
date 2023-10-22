package com.hunter.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.hunter.ricegrow.DatabaseFiles.Model.Pests;

import java.util.List;

@Dao
public interface PestDao {
    @Insert
    void insert (Pests pests);

    @Query("SELECT id FROM pests WHERE nameEn =:name")
    int getIdByName (String name);

    @Query("SELECT * FROM pests")
    List<Pests> getAllPests();

    @Query("SELECT * FROM pests WHERE nameEn LIKE :name OR nameVi LIKE :name")
    List<Pests> getPestsByName(String name);

    @Query("SELECT * FROM pests WHERE id IN (SELECT pest_id FROM pest_pesticides WHERE pesticide_id = :pesticideId)")
    List<Pests> getPestByPesticideId (int pesticideId);

    @Query("SELECT * FROM pests WHERE id IN (SELECT pest_id FROM crop_pests WHERE crop_id = :cropId)")
    List<Pests> getPestByCropId (int cropId);

    @Query("SELECT * FROM pests WHERE id IN (SELECT pest_id FROM pests_stages WHERE stage_id = :stageId)")
    List<Pests> getPestByStageId (int stageId);
}

package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ricegrow.DatabaseFiles.Model.Fertilizers;
import com.example.ricegrow.DatabaseFiles.Model.Pesticides;
import com.example.ricegrow.DatabaseFiles.Model.Stages;

import java.util.List;

@Dao
public interface StageDao {
    @Insert
    void insert (Stages stages);

    @Query("SELECT id FROM stages WHERE name =:name")
    int getIdByName (String name);

    @Query("SELECT * FROM stages WHERE crop_id =:cropId ORDER BY `order`")
    List<Stages> getAllStagesByCropId(int cropId);

    @Query("SELECT * FROM stages WHERE id =:id")
    Stages getStageById(int id);

    @Query("SELECT * FROM stages WHERE name LIKE :name")
    List<Stages> getStagesByName(String name);

    @Query("SELECT * FROM stages WHERE id IN (SELECT stage_id FROM diseases_stages WHERE disease_id = :diseaseId)")
    List<Stages> getStagesByDiseaseId (int diseaseId);

    @Query("SELECT * FROM stages WHERE id IN (SELECT stage_id FROM pests_stages WHERE pest_id = :pestId)")
    List<Stages> getStagesByPestId (int pestId);
}

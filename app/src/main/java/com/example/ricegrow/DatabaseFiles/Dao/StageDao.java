package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ricegrow.DatabaseFiles.Model.Stages;

import java.util.List;

@Dao
public interface StageDao {
    @Insert
    void insert (Stages stages);

    @Query("SELECT id FROM stages WHERE nameEn =:name")
    int getIdByName (String name);

    @Query("SELECT * FROM stages")
    List<Stages> getAllStages();

    @Query("SELECT * FROM stages ORDER BY `order` ASC")
    List<Stages> getAllStagesWithOrder();

    @Query("SELECT * FROM stages WHERE id =:id")
    Stages getStageById(int id);

    @Query("SELECT * FROM stages WHERE nameEn =:name")
    Stages getStageByName(String name);
    @Query("SELECT * FROM stages WHERE nameEn LIKE :name OR nameVi LIKE :name")
    List<Stages> getStagesByName(String name);

    @Query("SELECT * FROM stages WHERE id IN (SELECT stage_id FROM diseases_stages WHERE disease_id = :diseaseId)")
    List<Stages> getStagesByDiseaseId (int diseaseId);

    @Query("SELECT * FROM stages WHERE id IN (SELECT stage_id FROM pests_stages WHERE pest_id = :pestId)")
    List<Stages> getStagesByPestId (int pestId);

    @Query("SELECT * FROM stages WHERE id IN (SELECT stage_id FROM deftox_stage WHERE deftox_id = :deftoxId)")
    List<Stages> getStagesByDeftoxId (int deftoxId);
}

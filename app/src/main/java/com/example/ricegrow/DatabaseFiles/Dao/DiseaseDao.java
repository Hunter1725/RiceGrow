package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ricegrow.DatabaseFiles.Model.Diseases;

import java.util.List;

@Dao
public interface DiseaseDao {
    @Insert
    void insert (Diseases diseases);

    @Query("SELECT id FROM diseases WHERE nameEn =:name")
    int getIdByName (String name);

    @Query("SELECT * FROM diseases")
    List<Diseases> getAllDiseases();

    @Query("SELECT * FROM diseases WHERE nameEn LIKE :name OR nameVi LIKE :name")
    List<Diseases> getDiseasesByName(String name);

    @Query("SELECT * FROM diseases WHERE id IN (SELECT disease_id FROM diseases_pesticides WHERE pesticide_id = :pesticideId)")
    List<Diseases> getDiseaseByPesticideId (int pesticideId);

    @Query("SELECT * FROM diseases WHERE id IN (SELECT disease_id FROM crop_diseases WHERE crop_id = :cropId)")
    List<Diseases> getDiseaseByCropId (int cropId);

    @Query("SELECT * FROM diseases WHERE id IN (SELECT disease_id FROM diseases_stages WHERE stage_id = :stageId)")
    List<Diseases> getDiseaseByStageId (int stageId);
}

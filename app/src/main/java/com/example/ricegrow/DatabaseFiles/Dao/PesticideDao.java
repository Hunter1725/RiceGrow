package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ricegrow.DatabaseFiles.Model.Diseases;
import com.example.ricegrow.DatabaseFiles.Model.Pesticides;

import java.util.List;

@Dao
public interface PesticideDao {
    @Insert
    void insert (Pesticides pesticides);

    @Query("SELECT id FROM pesticides WHERE name =:name")
    int getIdByName (String name);

    @Query("SELECT * FROM pesticides")
    List<Pesticides> getAllPesticides();

    @Query("SELECT * FROM pesticides WHERE category=:category")
    List<Pesticides> getPesticidesByCate(String category);

    @Query("SELECT * FROM pesticides WHERE name LIKE :name")
    List<Pesticides> getPesticidesByName(String name);

    @Query("SELECT * FROM pesticides WHERE id IN (SELECT pesticide_id FROM diseases_pesticides WHERE disease_id = :diseaseId)")
    List<Pesticides> getPesticideByDiseaseId (int diseaseId);

    @Query("SELECT * FROM pesticides WHERE id IN (SELECT pesticide_id FROM pest_pesticides WHERE pest_id = :pestId)")
    List<Pesticides> getPesticideByPestId (int pestId);

    @Query("SELECT * FROM pesticides WHERE id IN (SELECT pesticide_id FROM weeds_pesticides WHERE weed_id = :weedId)")
    List<Pesticides> getPesticideByWeedId (int weedId);

    @Query("SELECT * FROM pesticides WHERE id IN (SELECT pesticide_id FROM activity_pesticides WHERE activity_id = :activityId)")
    List<Pesticides> getPesticideByActivityId (int activityId);
}

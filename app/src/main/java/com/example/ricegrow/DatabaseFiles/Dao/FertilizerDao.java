package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ricegrow.DatabaseFiles.Model.Fertilizers;
import com.example.ricegrow.DatabaseFiles.Model.Pesticides;

import java.util.List;

@Dao
public interface FertilizerDao {
    @Insert
    void insert (Fertilizers fertilizers);

    @Query("SELECT id FROM fertilizers WHERE name =:name")
    int getIdByName (String name);

    @Query("SELECT * FROM fertilizers")
    List<Fertilizers> getAllFertilizers();

    @Query("SELECT * FROM fertilizers WHERE name LIKE :name")
    List<Fertilizers> getFertilizersByName(String name);

    @Query("SELECT * FROM fertilizers WHERE id IN (SELECT fertilizer_id FROM activity_fertilizers WHERE activity_id = :activityId)")
    List<Fertilizers> getFertilizerByActivityId (int activityId);

    @Query("SELECT * FROM fertilizers WHERE id IN (SELECT fertilizer_id FROM deftox_fertilizer WHERE deftox_id = :deftoxId)")
    List<Fertilizers> getFertilizerByDeftoxId (int deftoxId);
}

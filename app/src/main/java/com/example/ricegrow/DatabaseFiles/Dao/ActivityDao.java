package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ricegrow.DatabaseFiles.Model.Activities;
import com.example.ricegrow.DatabaseFiles.Model.Fertilizers;
import com.example.ricegrow.DatabaseFiles.Model.Pests;

import java.util.List;

@Dao
public interface ActivityDao {
    @Insert
    void insert (Activities activities);

    @Query("SELECT id FROM activities WHERE name =:name")
    int getIdByName (String name);

    @Query("SELECT * FROM activities")
    List<Activities> getAllActivities();

    @Query("SELECT * FROM activities WHERE name =:name")
    Activities getActivityByName(String name);

    @Query("SELECT * FROM activities WHERE id =:id")
    Activities getActivityById(int id);

    @Query("SELECT * FROM activities WHERE name LIKE :name")
    List<Activities> getActivitiesByName(String name);

    @Query("SELECT * FROM activities WHERE id IN (SELECT activity_id FROM activity_fertilizers WHERE fertilizer_id = :fertilizerId)")
    List<Activities> getActivitiesByFertilizerId (int fertilizerId);

    @Query("SELECT * FROM activities WHERE id IN (SELECT activity_id FROM activity_pesticides WHERE pesticide_id = :pesticideId)")
    List<Activities> getActivitiesByPesticideId (int pesticideId);

    @Query("SELECT * FROM activities WHERE stage_id =:stageId")
    List<Activities> getActivitiesByStageId (int stageId);
}

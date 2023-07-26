package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ricegrow.DatabaseFiles.Model.Crops;
import com.example.ricegrow.DatabaseFiles.Model.UserCrops;

import java.util.List;

@Dao
public interface UserCropDao {
    @Insert
    void insert (UserCrops userCrops);

    @Query("SELECT * FROM user_crops")
    List<UserCrops> getAllUserCrops();

    @Delete
    void delete(UserCrops userCrops);
}

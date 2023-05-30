package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.ricegrow.DatabaseFiles.Model.UserCrops;

@Dao
public interface UserCropDao {
    @Insert
    void insert (UserCrops userCrops);
}

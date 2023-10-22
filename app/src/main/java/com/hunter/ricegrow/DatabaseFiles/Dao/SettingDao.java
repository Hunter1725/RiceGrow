package com.hunter.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.hunter.ricegrow.DatabaseFiles.Model.Setting;

@Dao
public interface SettingDao {
    @Insert
    void insert (Setting setting);

    @Query("SELECT * FROM setting LIMIT 1")
    Setting getAll();

    @Update
    void updateSetting(Setting setting);
}

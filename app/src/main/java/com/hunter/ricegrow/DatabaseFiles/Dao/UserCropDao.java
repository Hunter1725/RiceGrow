package com.hunter.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.hunter.ricegrow.DatabaseFiles.Model.UserCrops;

import java.util.List;

@Dao
public interface UserCropDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(UserCrops userCrops);

    @Query("SELECT * FROM user_crops")
    List<UserCrops> getAllUserCrops();

    @Query("SELECT * FROM user_crops ORDER BY id DESC LIMIT 2")
    List<UserCrops> getRecentUserCrops();

    @Delete
    void delete(UserCrops userCrops);

    @Query("SELECT * FROM user_crops WHERE id =:id")
    UserCrops getUserCropsById(int id);

    @Update
    void update (UserCrops userCrops);
}

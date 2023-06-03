package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ricegrow.DatabaseFiles.Model.Users;

@Dao
public interface UserDao {
    @Insert
    void insert (Users users);

    @Query("SELECT * FROM users WHERE id=:id")
    Users getUserById(String id);

    @Query("UPDATE users SET password =:pass WHERE id=:id")
    void updatePass(String pass, String id);
}

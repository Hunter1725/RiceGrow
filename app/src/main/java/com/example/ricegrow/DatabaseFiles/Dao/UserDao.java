package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.ricegrow.DatabaseFiles.Model.Users;

@Dao
public interface UserDao {
    @Insert
    void insert (Users users);
}

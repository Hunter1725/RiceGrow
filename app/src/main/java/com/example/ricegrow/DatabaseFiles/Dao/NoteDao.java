package com.example.ricegrow.DatabaseFiles.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ricegrow.DatabaseFiles.Model.Notes;

@Dao
public interface NoteDao {
    @Insert
    void insert (Notes notes);

    @Query("SELECT * FROM notes WHERE plan_activity_id =:id AND date =:dateInput")
    Notes getNotesByPlanActivityId(int id, long dateInput);

    @Delete
    void delete(Notes notes);
}

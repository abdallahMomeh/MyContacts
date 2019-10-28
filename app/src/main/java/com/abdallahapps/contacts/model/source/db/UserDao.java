package com.abdallahapps.contacts.model.source.db;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {


    @Query("SELECT * FROM User")
    LiveData<List<User>> getAllUser();

    @Insert
    long insertNewNote(User user);

}

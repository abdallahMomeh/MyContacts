package com.abdallahapps.contacts.model.source.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = User.class, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}

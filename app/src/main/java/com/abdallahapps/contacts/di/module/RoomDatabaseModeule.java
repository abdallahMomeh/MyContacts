package com.abdallahapps.contacts.di.module;

import android.content.Context;

import com.abdallahapps.contacts.di.repo.UserDataSource;
import com.abdallahapps.contacts.model.source.db.MyDatabase;
import com.abdallahapps.contacts.model.source.db.UserDao;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

@Module
public class RoomDatabaseModeule {


    MyDatabase myDatabase;

    public RoomDatabaseModeule(Context context){
        myDatabase = Room.databaseBuilder(context,MyDatabase.class,"my.db").build();
    }


    @Provides
    public MyDatabase provideDatabase(){
        return myDatabase;
    }


    @Provides
    public UserDao providesUserDao(MyDatabase myDatabase){
        return myDatabase.userDao();
    }

    @Provides
    public UserDataSource providesDataSource(UserDao userDao){
        return new UserDataSource(userDao);
    }


}

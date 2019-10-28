package com.abdallahapps.contacts.ui.main.repo;

import android.util.Log;

import com.abdallahapps.contacts.di.repo.UserDataSource;
import com.abdallahapps.contacts.model.source.db.User;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;

public class MainRepository {


    UserDataSource userDataSource;

    @Inject
    public MainRepository(UserDataSource userDataSource) {
        this.userDataSource = userDataSource;

        Log.d("myTag", "MainRepository:  constructor");
    }


    public void insertUser(User user){
        userDataSource.insert(user);
    }

    public LiveData<List<User>> getAllUsers(){
        return  userDataSource.getAllUsers();
    }

}

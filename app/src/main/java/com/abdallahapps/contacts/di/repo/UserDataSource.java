package com.abdallahapps.contacts.di.repo;

import com.abdallahapps.contacts.model.source.db.User;
import com.abdallahapps.contacts.model.source.db.UserDao;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;

public class UserDataSource implements UserRepository {

    private UserDao userDao;

    @Inject
    public UserDataSource(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public long insert(User user) {
        return userDao.insertNewNote(user);
    }

    @Override
    public LiveData<List<User>> getAllUsers() {
        return userDao.getAllUser();
    }

}

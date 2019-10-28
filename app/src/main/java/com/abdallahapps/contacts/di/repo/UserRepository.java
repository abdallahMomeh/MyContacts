package com.abdallahapps.contacts.di.repo;

import com.abdallahapps.contacts.model.source.db.User;

import java.util.List;

import androidx.lifecycle.LiveData;

public interface UserRepository {

    long insert(User user);
    LiveData<List<User>> getAllUsers();

}

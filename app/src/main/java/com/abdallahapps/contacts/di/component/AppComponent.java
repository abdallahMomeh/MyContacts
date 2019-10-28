package com.abdallahapps.contacts.di.component;

import android.content.SharedPreferences;

import com.abdallahapps.contacts.di.module.RoomDatabaseModeule;
import com.abdallahapps.contacts.di.repo.UserDataSource;
import com.abdallahapps.contacts.model.source.db.MyDatabase;
import com.abdallahapps.contacts.ui.main.di.module.SharedMangerModule;

import dagger.Component;

//@ApplicationContextScope
@Component(modules = {RoomDatabaseModeule.class, SharedMangerModule.class})
public interface AppComponent {

    UserDataSource exposeUserDataSourse();
    MyDatabase exposeDatabase();
    SharedPreferences exposePreferences();

}

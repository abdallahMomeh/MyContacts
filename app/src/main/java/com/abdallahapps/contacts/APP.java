package com.abdallahapps.contacts;

import android.content.Context;

import com.abdallahapps.contacts.di.component.AppComponent;
import com.abdallahapps.contacts.di.component.DaggerAppComponent;
import com.abdallahapps.contacts.di.module.RoomDatabaseModeule;
import com.abdallahapps.contacts.model.source.db.MyDatabase;
import com.abdallahapps.contacts.ui.main.di.module.SharedMangerModule;

import javax.inject.Inject;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

public class APP extends MultiDexApplication {

    AppComponent appComponent;

    @Inject
    MyDatabase myDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .sharedMangerModule(new SharedMangerModule(this))
                .roomDatabaseModeule(new RoomDatabaseModeule(this))
                .build();

       /* if (myDatabase == null){
            Log.d("myTag", "onCreate: mydatabase is null");
        }else
            Log.d("myTag", "onCreate: mydatabase is not null");
*/
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }

}

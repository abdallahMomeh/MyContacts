package com.abdallahapps.contacts.ui.main.di.module;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedMangerModule {

    Context mContext;

    @Inject
    public SharedMangerModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    SharedPreferences providesSharedPreference() {
        return mContext.getSharedPreferences("my_shared_pref", Context.MODE_PRIVATE);
    }


}

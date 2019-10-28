package com.abdallahapps.contacts.ui.main.di.module;

import com.abdallahapps.contacts.ui.main.viewModel.MainViewModelFactory;

import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainVMFactoryModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(MainViewModelFactory factory);
}

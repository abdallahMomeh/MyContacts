package com.abdallahapps.contacts.ui.main.viewModel;

import com.abdallahapps.contacts.ui.main.repo.MainRepository;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainViewModelFactory implements ViewModelProvider.Factory {

    private MainRepository mainRepository;

    @Inject
    public MainViewModelFactory(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

//        Provider<? extends ViewModel> creator = creators.get(modelClass);
        return (T) new MainVM(mainRepository);

    }

}

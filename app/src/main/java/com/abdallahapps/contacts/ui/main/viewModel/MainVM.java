package com.abdallahapps.contacts.ui.main.viewModel;

import android.util.Log;

import com.abdallahapps.contacts.model.source.db.User;
import com.abdallahapps.contacts.ui.main.repo.MainRepository;

import java.util.List;

import javax.inject.Inject;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainVM extends ViewModel {

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> phone = new ObservableField<>("");

    MainRepository mainRepository;

    @Inject
    public MainVM(MainRepository mainRepository){
        this.mainRepository = mainRepository;
    }


    public LiveData<List<User>> getAllUsers(){
        return mainRepository.getAllUsers();
    }

    public void insertUser(User user) {

        Completable.fromAction(() -> {
            mainRepository.insertUser(user);
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    Log.d("myTag", "insertUser: success");
                 },throwable -> {
                    Log.d("myTag", "insertUser: error");
                    throwable.printStackTrace();
                });

    }

    public void onSaveClicked(){

        if (name.get().length()>0 && phone.get().length()>0){

            User user = new User();
            user.setName(name.get());
            user.setPhone(phone.get());

            insertUser(user);

        }

    }

}

package com.abdallahapps.contacts.ui.main.view;


import android.os.Bundle;

import com.abdallahapps.contacts.APP;
import com.abdallahapps.contacts.R;
import com.abdallahapps.contacts.databinding.ActivityMainBinding;
import com.abdallahapps.contacts.ui.main.di.component.DaggerMainComponent;
import com.abdallahapps.contacts.ui.main.di.component.MainComponent;
import com.abdallahapps.contacts.ui.main.viewModel.MainVM;
import com.abdallahapps.contacts.ui.main.viewModel.MainViewModelFactory;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

public class MainActivity extends AppCompatActivity {


    @Inject MainViewModelFactory mainViewModelFactory;

    MainComponent mainComponent;

    MainVM mainVM;
    ActivityMainBinding activityMainBinding;
    UserRVAdapter userRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mainComponent = DaggerMainComponent.builder()
                .appComponent(((APP)getApplicationContext()).getAppComponent()).build();
        mainComponent.inject(this);

        mainVM = ViewModelProviders.of(this,mainViewModelFactory).get(MainVM.class);

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setViewModel(mainVM);

        initRV();

        mainVM.getAllUsers().observe(this,users -> {
            userRVAdapter.setUsers(users);
        });


    }

    void initRV(){
        userRVAdapter = new UserRVAdapter();
        activityMainBinding.userRV.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.userRV.setAdapter(userRVAdapter);
    }


}

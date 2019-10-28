package com.abdallahapps.contacts.ui.main.di.component;


import com.abdallahapps.contacts.di.component.AppComponent;
import com.abdallahapps.contacts.ui.main.di.module.MainVMFactoryModule;
import com.abdallahapps.contacts.ui.main.view.MainActivity;

import dagger.Component;

//@MainContextScope
@Component(dependencies = AppComponent.class, modules = {MainVMFactoryModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}

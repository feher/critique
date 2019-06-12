package com.dreambroker.garage.critique.di;

import com.dreambroker.garage.critique.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { MainModule.class })
public interface MainComponent {

    void inject(MainActivity mainActivity);

}

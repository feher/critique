package com.dreambroker.garage.critique;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { NetworkModule.class })
public interface MainComponent {

    void inject(MainActivity mainActivity);

}

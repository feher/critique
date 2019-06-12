package com.dreambroker.garage.critique;

import android.app.Application;

import timber.log.Timber;

public class CritiqueApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}

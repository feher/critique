package com.dreambroker.garage.critique;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private ImageLiveData imageLiveData;

    @Inject
    public MainViewModel(ImageLiveData imageLiveData) {
        this.imageLiveData = imageLiveData;
    }

    public ImageLiveData getImageLiveData() {
        return imageLiveData;
    }
}

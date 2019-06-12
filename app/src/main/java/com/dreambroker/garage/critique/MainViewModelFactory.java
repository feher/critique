package com.dreambroker.garage.critique;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainViewModelFactory implements ViewModelProvider.Factory {

    private final ImageLiveData imageLiveData;

    @Inject
    public MainViewModelFactory(ImageLiveData imageLiveData) {
        this.imageLiveData = imageLiveData;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        ViewModel viewModel;
        if (modelClass == MainViewModel.class) {
            viewModel = new MainViewModel(imageLiveData);
        }
        else {
            throw new RuntimeException("unsupported view model class: " + modelClass);
        }

        return (T) viewModel;
    }
}

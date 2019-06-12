package com.dreambroker.garage.critique;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class ImageLiveData extends LiveData<List<Image>> {

    private static int IMAGE_COUNT = 100;

    private ImageRepository imageRepository;
    private Disposable disposable;

    @Inject
    public ImageLiveData(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    protected void onActive() {
        super.onActive();
        disposable = imageRepository.getImages(IMAGE_COUNT)
                .subscribeOn(Schedulers.io())
                .subscribe(images -> postValue(images), Timber::e);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        disposable.dispose();
    }

}

package com.dreambroker.garage.critique.repository;

import android.net.Uri;

import com.dreambroker.garage.critique.model.Image;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import timber.log.Timber;

@Singleton
public class ImageRepository {

    private ImageApi imageApi;

    @Inject
    public ImageRepository(ImageApi imageApi) {
        this.imageApi = imageApi;
    }

    public Single<List<Image>> getImages(int count) {
        return imageApi.getImageMetaData()
                .flatMap( imageMetaData -> Single.fromCallable(() -> {
                    List<Image> images = new ArrayList<>();

                    if (!imageMetaData.extensions.isEmpty()
                            && !imageMetaData.imageTexts.isEmpty()
                            && !imageMetaData.fileSizes.isEmpty()) {
                        int fileSizeIndex = Math.min(imageMetaData.fileSizes.size(), 1);
                        for (int i = 0; i < count; ++i) {
                            int extensionIndex = i % imageMetaData.extensions.size();
                            int textIndex = i % imageMetaData.imageTexts.size();
                            String extension = imageMetaData.extensions.get(extensionIndex);
                            String text = imageMetaData.imageTexts.get(textIndex);
                            String fileSize = imageMetaData.fileSizes.get(fileSizeIndex);
                            Uri uri = Uri.parse(imageMetaData.baseUrl + imageMetaData.apiPath
                                                        + "/Sample-" + extension + "-image-" + fileSize + "." + extension);
                            images.add(new Image(uri, text));
                        }
                    } else {
                        Timber.w("Missing metadata");
                    }

                    return images;
                }));
    }

}

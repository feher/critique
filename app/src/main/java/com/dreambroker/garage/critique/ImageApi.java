package com.dreambroker.garage.critique;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ImageApi {

    @GET("data")
    Single<ImageMetaData> getImageMetaData();

}

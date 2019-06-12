package com.dreambroker.garage.critique.repository;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ImageApi {

    @GET("data")
    Single<ImageMetaData> getImageMetaData();

}

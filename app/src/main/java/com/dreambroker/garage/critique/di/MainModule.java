package com.dreambroker.garage.critique.di;

import com.dreambroker.garage.critique.repository.ImageApi;
import com.dreambroker.garage.critique.ImageLiveData;
import com.dreambroker.garage.critique.MainViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MainModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        return (new Retrofit.Builder())
                .client(client)
                .baseUrl("https://my-json-server.typicode.com/mdislam/rest_service/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public ImageApi provideImageApi(Retrofit retrofit) {
        return retrofit.create(ImageApi.class);
    }

    @Provides
    public MainViewModel provideMainViewModel(ImageLiveData imageLiveData) {
        return new MainViewModel(imageLiveData);
    }

}

package com.example.mobsoft.mobsoft.network;

/**
 * Created by mobsoft on 2017. 04. 24..
 */


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.example.mobsoft.mobsoft.network.event.EventApi;
import com.example.mobsoft.mobsoft.network.login.LoginApi;
import com.example.mobsoft.mobsoft.utils.GsonHelper;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient().newBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(NetworkConfig.SERVICE_ENDPOINT).client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson())).build();
    }

    @Provides
    @Singleton
    public EventApi provideEventApi(Retrofit retrofit) {
        return retrofit.create(EventApi.class);
    }

    @Provides
    @Singleton
    public LoginApi provideLoginApi(Retrofit retrofit) {
        return retrofit.create(LoginApi.class);
    }

}

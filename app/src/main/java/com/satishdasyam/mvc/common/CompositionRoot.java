package com.satishdasyam.mvc.common;

import com.satishdasyam.mvc.networking.RestService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompositionRoot {

    private RestService mRestService;

    public RestService getApi() {
        if (mRestService == null) {
            mRestService = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .build()
                    .create(RestService.class);
        }
        return mRestService;
    }
}

package com.example.phuwarin.someapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Phuwarin on 3/16/2017.
 */

public class RetrofitCreation {
    private static final RetrofitCreation ourInstance = new RetrofitCreation();
    private ApiService service;

    public static RetrofitCreation getInstance() {
        if (ourInstance == null) {
            return new RetrofitCreation();
        } else {
            return ourInstance;
        }
    }

    private RetrofitCreation() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://161.246.103.187/member_database/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ApiService.class);
    }

    public ApiService getService() {
        return service;
    }
}

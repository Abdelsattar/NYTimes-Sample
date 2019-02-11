package com.sattar.nytimessample.utils;

import com.sattar.nytimessample.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created By Sattar 2/11/2019
 */
public class ApiClient {


    private static Retrofit retrofit = null;

    public static Retrofit getClient() {


        if (retrofit != null)
            return retrofit;
        return retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.ApiBaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}

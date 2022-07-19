package com.example.dogsapphomework;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {

    private static ApiService apiService;
    private final static String BASE_URL = "https://dog.ceo/api/breeds/image/";

    public static ApiService getApiService() {
        if (apiService == null) {
            Retrofit retrofit = new Retrofit.Builder().
                    baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).
                    addCallAdapterFactory(RxJava3CallAdapterFactory.create()).
                    build();
            apiService = retrofit.create(ApiService.class);
        }
        return  apiService;
    }
}

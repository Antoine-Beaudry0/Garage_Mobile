package com.antoinebeaudry.garage_mobile.classes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {


    public static final String BASE_URL = "https://172.16.87.101:8002/api"; // jai ajouter le s
    private static Retrofit retrofit;

    public static Retrofit getInstance(){

        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}

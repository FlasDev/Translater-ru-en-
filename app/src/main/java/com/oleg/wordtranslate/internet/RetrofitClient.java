package com.oleg.wordtranslate.internet;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by oleg on 13.02.2018.
 */

public class RetrofitClient {

    public static Retrofit getRetrofitClient(String baseUrl){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        return retrofit;
    }
}

package com.oleg.wordtranslate.internet;

import retrofit2.Retrofit;

/**
 * Created by oleg on 13.02.2018.
 */

public class ApiUtils {
    private static final String BASE_URL = "https://translate.yandex.net/";
    public static final String API ="trnsl.1.1.20180212T182354Z.b24a970fcabe8899.8ad4d090805588d5e26c4d27adbc8bbb673f93f7";
    public static IYandex getYandexApi(){
        return RetrofitClient.getRetrofitClient(BASE_URL).create(IYandex.class);
    }
}

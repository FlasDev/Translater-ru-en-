package com.oleg.wordtranslate.internet;

import com.oleg.wordtranslate.model.YandexLangs;
import com.oleg.wordtranslate.model.YandexTranslate;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by oleg on 13.02.2018.
 */

public interface IYandex {

    @GET("api/v1.5/tr.json/translate")
    Call<YandexTranslate> getLangs(@Query("key")String api,
                                   @Query("text")String text,
                                   @Query("lang")String lang);
}

package com.oleg.wordtranslate.model;

import java.util.UUID;

/**
 * Created by oleg on 02.02.2018.
 */

public class MainTranslate {
    private String mWord;
    private String mTranslate;
    private UUID mUUID;

    public MainTranslate() {
        this(UUID.randomUUID());
    }

    public MainTranslate(UUID uuid){
        mUUID = uuid;
    }

    public UUID getUUID() {
        return mUUID;
    }

    public String getWord() {
        return mWord;
    }

    public void setWord(String word) {
        mWord = word;
    }

    public String getTranslate() {
        return mTranslate;
    }

    public void setTranslate(String translate) {
        mTranslate = translate;
    }
}

package com.oleg.wordtranslate.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.oleg.wordtranslate.model.MainTranslate;

import java.util.UUID;

/**
 * Created by oleg on 02.02.2018.
 */

public class TranslateCursorWrapper extends CursorWrapper {

    public TranslateCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public MainTranslate getTranslate(){
        String uuidString = getString(getColumnIndex(TranslateDBSchema.TranslateTable.Colums.UUID));
        String text = getString(getColumnIndex(TranslateDBSchema.TranslateTable.Colums.TEXT));
        String translate = getString(getColumnIndex(TranslateDBSchema.TranslateTable.Colums.TRANSLATE));

        MainTranslate mainTranslate = new MainTranslate(UUID.fromString(uuidString));
        mainTranslate.setWord(text);
        mainTranslate.setTranslate(translate);

        return mainTranslate;
    }
}

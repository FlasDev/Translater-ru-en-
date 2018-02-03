package com.oleg.wordtranslate.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by oleg on 02.02.2018.
 */

public class TranslateBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "translate.db";

    public TranslateBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TranslateDBSchema.TranslateTable.NAME + "(" +
                " _id integer primary key autoincrement, "+
                TranslateDBSchema.TranslateTable.Colums.UUID+", "+
                TranslateDBSchema.TranslateTable.Colums.TEXT+", "+
                TranslateDBSchema.TranslateTable.Colums.TRANSLATE+")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

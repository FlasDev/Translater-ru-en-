package com.oleg.wordtranslate.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.oleg.wordtranslate.database.TranslateBaseHelper;
import com.oleg.wordtranslate.database.TranslateCursorWrapper;
import com.oleg.wordtranslate.database.TranslateDBSchema;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 02.02.2018.
 */

public class TranslateLab{
    private Context mContext;
    private SQLiteDatabase mDatabase;


    public TranslateLab(Context packageContext) {
        mContext = packageContext.getApplicationContext();
        mDatabase = new TranslateBaseHelper(mContext).getWritableDatabase();

    }

   private static ContentValues getContentValues(MainTranslate mainTranslate){
        ContentValues values = new ContentValues();
        values.put(TranslateDBSchema.TranslateTable.Colums.UUID, String.valueOf(mainTranslate.getUUID()));
        values.put(TranslateDBSchema.TranslateTable.Colums.TEXT, String.valueOf(mainTranslate.getWord()));
        values.put(TranslateDBSchema.TranslateTable.Colums.TRANSLATE, String.valueOf(mainTranslate.getTranslate()));
        return values;
   }

   public void addTranslate(MainTranslate mainTranslate){
       ContentValues values = getContentValues(mainTranslate);
       mDatabase.insert(TranslateDBSchema.TranslateTable.NAME,null,values);
   }


   public List<MainTranslate> getTranslate(){
       List<MainTranslate>mainTranslates = new ArrayList<>();

       TranslateCursorWrapper cursorWrapper = queryTranslate(null,null);

       try {
           cursorWrapper.moveToFirst();
           while (!cursorWrapper.isAfterLast()){
               mainTranslates.add(cursorWrapper.getTranslate());
               cursorWrapper.moveToNext();
           }
       }finally {
           cursorWrapper.close();
       }
       return mainTranslates;
   }

   private TranslateCursorWrapper queryTranslate(String whereClause, String[] whereArgs){
       Cursor cursor = mDatabase.query(
               TranslateDBSchema.TranslateTable.NAME,
               null,
               whereClause,
               whereArgs,
               null,
               null,
               null
       );
       return new TranslateCursorWrapper(cursor);
   }
}

package com.oleg.wordtranslate.model;

import android.content.Context;
import android.util.Log;

import com.oleg.wordtranslate.database.TranslateDbDao;
import android.app.Application;
import java.util.List;

/**
 * Created by oleg on 04.02.2018.
 */

public class TranslateLab {
    private static final String LOG = "myLogs";
    private DaoSession mTranslateDaoSession;

    public TranslateLab(Application application) {
        mTranslateDaoSession = ((TranslateDbDao)application).getDaoSession();
    }

    public List<TranslateDao> loadTranslate(){
        return mTranslateDaoSession.getTranslateDaoDao().loadAll();
    }
    public void addTranslate(TranslateDao translateDao){
        mTranslateDaoSession.getTranslateDaoDao().insert(translateDao);
    }

    public long getNextIdTranslate(){
        return mTranslateDaoSession.getTranslateDaoDao().count()+1;
    }

    public TranslateDao loadSingleTranslate(long id){
        return mTranslateDaoSession.getTranslateDaoDao().load(id);
    }

    public void deleteSingleTranslate(long id){
        mTranslateDaoSession.getTranslateDaoDao().deleteByKey(id);
    }

    public void updateSingleTranslate(TranslateDao translateDao){
        mTranslateDaoSession.getTranslateDaoDao().update(translateDao);
    }

}

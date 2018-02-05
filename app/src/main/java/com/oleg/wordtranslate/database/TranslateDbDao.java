package com.oleg.wordtranslate.database;

import android.app.Application;
import android.util.Log;

import com.oleg.wordtranslate.model.DaoMaster;
import com.oleg.wordtranslate.model.DaoSession;
import com.oleg.wordtranslate.model.TranslateDao;

/**
 * Created by oleg on 04.02.2018.
 */


public class TranslateDbDao extends Application {
    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        mDaoSession = new DaoMaster(new DaoMaster.DevOpenHelper(this, "mytranslater.db",null).getWritableDb()).newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

}

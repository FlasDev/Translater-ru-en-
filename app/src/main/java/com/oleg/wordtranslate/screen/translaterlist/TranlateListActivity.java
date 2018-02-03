package com.oleg.wordtranslate.screen.translaterlist;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.oleg.wordtranslate.screen.SingleFragmentActivity;
import com.oleg.wordtranslate.screen.translater.TranslateActivity;

/**
 * Created by oleg on 02.02.2018.
 */

public class TranlateListActivity extends SingleFragmentActivity {
    @Override
    public Fragment createFragment() {
        return TranslateListFragment.newInstance();
    }

}

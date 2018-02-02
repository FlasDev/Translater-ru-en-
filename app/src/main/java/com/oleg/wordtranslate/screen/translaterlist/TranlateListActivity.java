package com.oleg.wordtranslate.screen.translaterlist;

import android.support.v4.app.Fragment;

import com.oleg.wordtranslate.screen.SingleFragmentActivity;

/**
 * Created by oleg on 02.02.2018.
 */

public class TranlateListActivity extends SingleFragmentActivity {
    @Override
    public Fragment createFragment() {
        return TranslateListFragment.newInstance();
    }
}

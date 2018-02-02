package com.oleg.wordtranslate;

import android.support.v4.app.Fragment;

public class TranslateActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return TranslatorFragment.newInstance();
    }
}

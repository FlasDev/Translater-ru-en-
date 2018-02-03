package com.oleg.wordtranslate.screen.translater;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.oleg.wordtranslate.screen.SingleFragmentActivity;

public class TranslateActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return TranslatorFragment.newInstance();
    }


    public static Intent newIntent(Context packageContext){
        Intent intent = new Intent(packageContext, TranslateActivity.class);
        return intent;
    }
}

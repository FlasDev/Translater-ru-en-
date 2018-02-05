package com.oleg.wordtranslate.screen.translater;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.widget.EditText;

import com.oleg.wordtranslate.screen.SingleFragmentActivity;

public class TranslateActivity extends SingleFragmentActivity {
    private static final String EXTRA_TRANSLATE_ID = "com.oleg.screen.wordtranslate.translate_id";
    @Override
    public Fragment createFragment() {
        try {
            long id = (long) getIntent().getSerializableExtra(EXTRA_TRANSLATE_ID);
            return TranslatorFragment.newInstance(id);
        }catch (NullPointerException e){
            return TranslatorFragment.newInstance();
        }
    }


    public static Intent newIntent(Context packageContext, long id){
        Intent intent = new Intent(packageContext, TranslateActivity.class);
        intent.putExtra(EXTRA_TRANSLATE_ID,id);
        return intent;
    }

    public static Intent newIntent(Context packageContext){
        Intent intent = new Intent(packageContext, TranslateActivity.class);
        return intent;
    }
}

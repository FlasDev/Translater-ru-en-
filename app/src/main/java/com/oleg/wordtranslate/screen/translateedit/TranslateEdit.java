package com.oleg.wordtranslate.screen.translateedit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.oleg.wordtranslate.R;

/**
 * Created by oleg on 05.02.2018.
 */

public class TranslateEdit extends AppCompatActivity {
    private static final String LOG = "myLogs";
    private static final String EXTRA_TRANSLATE_ID = "com.oleg.wordtranslate.translate_id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);


        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if(fragment == null){
            fragment = createFragment();
            fm.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    public Fragment createFragment() {
        long id = (long)getIntent().getSerializableExtra(EXTRA_TRANSLATE_ID);
        return TranslateEditFragment.newInstance(id);
    }



    public static Intent newIntent(Context packageContext, long id){
        Intent intent = new Intent(packageContext,TranslateEdit.class);
        intent.putExtra(EXTRA_TRANSLATE_ID,id);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        return intent;
    }
}

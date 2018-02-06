package com.oleg.wordtranslate.screen.translater;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;

import com.oleg.wordtranslate.R;
import com.oleg.wordtranslate.screen.SingleFragmentActivity;
import com.oleg.wordtranslate.screen.translatelearn.TranslateLearnActivity;
import com.oleg.wordtranslate.screen.translaterlist.TranlateListActivity;

public class TranslateActivity extends SingleFragmentActivity {
    private static final String LOG = "myLogs";
    @Override
    public Fragment createFragment() {
            return TranslatorFragment.newInstance();
    }

    public static Intent newIntent(Context packageContext){
        Log.d(LOG,"новый интент");
        Intent intent = new Intent(packageContext, TranslateActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        return intent;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.nav_draw_translate){
            startActivity(TranlateListActivity.newIntent(this));
        }else if(id == R.id.nav_draw_learn_words){
            startActivity(TranslateLearnActivity.newIntent(this));

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

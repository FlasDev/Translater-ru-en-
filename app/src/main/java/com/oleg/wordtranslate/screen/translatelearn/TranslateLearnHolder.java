package com.oleg.wordtranslate.screen.translatelearn;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.oleg.wordtranslate.R;
import com.oleg.wordtranslate.model.TranslateDao;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oleg on 06.02.2018.
 */

public class TranslateLearnHolder extends RecyclerView.ViewHolder {
    private static final String LOG = "myLogs";
    private TranslateDao mTranslateDao;
    @BindView(R.id.item_recycler_view_learn) Button mButtonChecked;


    public TranslateLearnHolder(View itemView,TranslateLearnFragment translateLearnFragment) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mButtonChecked.setOnClickListener(v -> {
            if(translateLearnFragment.isTrueAnswer(mTranslateDao.getName(),itemView)){
                translateLearnFragment.updateUI();
            }else {
                translateLearnFragment.loadLeftAnswer();
            }
        });

    }

    public void bindAnswerTranslate(TranslateDao translateDao){
        mTranslateDao = translateDao;
        mButtonChecked.setText(translateDao.getName());
    }


}

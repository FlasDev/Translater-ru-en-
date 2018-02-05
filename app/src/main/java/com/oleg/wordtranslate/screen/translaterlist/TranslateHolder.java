package com.oleg.wordtranslate.screen.translaterlist;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.oleg.wordtranslate.R;
import com.oleg.wordtranslate.database.TranslateDbDao;
import com.oleg.wordtranslate.model.TranslateDao;
import com.oleg.wordtranslate.model.TranslateLab;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oleg on 02.02.2018.
 */

public class TranslateHolder extends RecyclerView.ViewHolder {
    private static final String LOG = "myLogs";
    private TranslateDao mTranslateDao;
    private int mPosition;
    @BindView(R.id.list_item_text) TextView mTextView;
    @BindView(R.id.list_item_translate) TextView mTranslateView;
    @BindView(R.id.list_item_image_clear)ImageButton mImageClear;
    public TranslateHolder(View itemView, Context packageContext, TranslateListFragment fragment) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        itemView.setOnClickListener(v -> {
            TranslateListFragment.startIntent(packageContext,mTranslateDao.getId());
    });
        mImageClear.setOnClickListener(v -> {
            TranslateLab translateLab = new TranslateLab((Application) packageContext.getApplicationContext());
            translateLab.deleteSingleTranslate(mTranslateDao.getId());
            fragment.updateUI();
        });
    }

    public void bindTranslate(TranslateDao translate,int position){
        mPosition = position;
        mTranslateDao = translate;
        mTextView.setText(translate.getName());
        mTranslateView.setText(translate.getTranslate());
    }
}

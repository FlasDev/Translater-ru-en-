package com.oleg.wordtranslate.screen.translaterlist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.oleg.wordtranslate.R;
import com.oleg.wordtranslate.model.MainTranslate;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oleg on 02.02.2018.
 */

public class TranslateHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.list_item_text) TextView mTextView;
    @BindView(R.id.list_item_translate) TextView mTranslateView;
    public TranslateHolder(View itemView, Context packageContext) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        itemView.setOnClickListener(v -> {
            TranslateListFragment.startIntent(packageContext);
    });
    }

    public void bindTranslate(MainTranslate translate){
        mTextView.setText(translate.getWord());
        mTranslateView.setText(translate.getTranslate());
    }
}

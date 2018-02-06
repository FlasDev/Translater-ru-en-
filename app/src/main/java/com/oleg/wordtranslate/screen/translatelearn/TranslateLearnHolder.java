package com.oleg.wordtranslate.screen.translatelearn;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
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
    @BindView(R.id.item_recycler_view_learn)
    RadioButton mCheckedTextView;

    public TranslateLearnHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        itemView.setOnClickListener(v -> {
        });
    }

    public void bindAnswerTranslate(TranslateDao translateDao){
        Log.d(LOG,"holder "+translateDao.getName());
        mCheckedTextView.setText(translateDao.getTranslate());
    }


}

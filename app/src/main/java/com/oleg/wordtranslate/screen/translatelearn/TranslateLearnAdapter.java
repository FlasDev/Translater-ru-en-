package com.oleg.wordtranslate.screen.translatelearn;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oleg.wordtranslate.R;
import com.oleg.wordtranslate.model.TranslateDao;

import java.util.List;

/**
 * Created by oleg on 06.02.2018.
 */

public class TranslateLearnAdapter extends RecyclerView.Adapter<TranslateLearnHolder> {
    private List<TranslateDao> mAnswerList;
    private Context mContext;
    private TranslateLearnFragment mTranslateLearnFragment;

    public TranslateLearnAdapter(List<TranslateDao> answerList, Context context,TranslateLearnFragment translateLearnFragment) {
        mAnswerList = answerList;
        mContext = context;
        mTranslateLearnFragment = translateLearnFragment;
    }

    @Override
    public TranslateLearnHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.list_item_learn_translate,parent,false);
        return new TranslateLearnHolder(view,mTranslateLearnFragment);
    }

    @Override
    public void onBindViewHolder(TranslateLearnHolder holder, int position) {
        TranslateDao translateDao = mAnswerList.get(position);
        holder.bindAnswerTranslate(translateDao);
    }

    @Override
    public int getItemCount() {
        return mAnswerList.size();
    }
}

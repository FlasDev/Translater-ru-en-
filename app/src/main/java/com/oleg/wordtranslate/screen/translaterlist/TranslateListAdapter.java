package com.oleg.wordtranslate.screen.translaterlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oleg.wordtranslate.R;
import com.oleg.wordtranslate.model.MainTranslate;

import java.util.List;

/**
 * Created by oleg on 02.02.2018.
 */

public class TranslateListAdapter extends RecyclerView.Adapter<TranslateHolder> {
    private List<MainTranslate> mTranslates;
    private Context mContext;

    public TranslateListAdapter(List<MainTranslate> list, Context context) {
        mTranslates = list;
        mContext = context;
    }

    @Override
    public TranslateHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater  = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.list_item_translater,parent,false);
        return new TranslateHolder(view,mContext);
    }

    @Override
    public void onBindViewHolder(TranslateHolder holder, int position) {
        MainTranslate mainTranslate = mTranslates.get(position);
        holder.bindTranslate(mainTranslate);
    }

    @Override
    public int getItemCount() {
        return mTranslates.size();
    }
}

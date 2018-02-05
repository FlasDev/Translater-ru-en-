package com.oleg.wordtranslate.screen.translaterlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oleg.wordtranslate.R;
import com.oleg.wordtranslate.model.TranslateDao;

import java.util.List;

/**
 * Created by oleg on 02.02.2018.
 */

public class TranslateListAdapter extends RecyclerView.Adapter<TranslateHolder> {
    private static final String LOG = "myLogs";
    private List<TranslateDao> mTranslates;
    private Context mContext;
    private TranslateListFragment mTranslateListFragment;

    public TranslateListAdapter(List<TranslateDao> list, Context context,TranslateListFragment fragment) {
        mTranslates = list;
        mContext = context;
        mTranslateListFragment = fragment;
    }

    @Override
    public TranslateHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater  = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.list_item_translater,parent,false);
        return new TranslateHolder(view,mContext,mTranslateListFragment);
    }

    @Override
    public void onBindViewHolder(TranslateHolder holder, int position) {
        TranslateDao translateDao = mTranslates.get(position);
        holder.bindTranslate(translateDao,position);
    }

    @Override
    public int getItemCount() {
        return mTranslates.size();
    }


}

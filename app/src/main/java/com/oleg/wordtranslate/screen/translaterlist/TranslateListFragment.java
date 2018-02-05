package com.oleg.wordtranslate.screen.translaterlist;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oleg.wordtranslate.R;
import com.oleg.wordtranslate.model.TranslateDao;
import com.oleg.wordtranslate.model.TranslateLab;
import com.oleg.wordtranslate.screen.translater.TranslateActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class TranslateListFragment extends Fragment {
    private static final String LOG = "myLogs";
    private TranslateListAdapter mAdapter;
    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;
    @BindView(R.id.fragment_translator_list_fab) FloatingActionButton mFloatingActionButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_translate_list, container, false);
        ButterKnife.bind(this,view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        mFloatingActionButton.setOnClickListener(v -> {
            startIntent(getActivity());
        });
        return view;
    }

    public void updateUI() {
        TranslateLab mTranslateLab = new TranslateLab(getActivity().getApplication());
        List<TranslateDao> translateDaoList = mTranslateLab.loadTranslate();

        if(mAdapter == null) {
            mAdapter = new TranslateListAdapter(translateDaoList, getActivity(),this);
            mRecyclerView.setAdapter(mAdapter);
        }
    }



    public static TranslateListFragment newInstance(){
        return new TranslateListFragment();
    }


    public static void startIntent(Context packageContext, long id){
        Intent intent = TranslateActivity.newIntent(packageContext, id);
        packageContext.startActivity(intent);
    }

    public static void startIntent(Context packageContext){
        Intent intent = TranslateActivity.newIntent(packageContext);
        packageContext.startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}

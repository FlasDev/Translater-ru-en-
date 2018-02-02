package com.oleg.wordtranslate.screen.translaterlist;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oleg.wordtranslate.R;
import com.oleg.wordtranslate.model.MainTranslate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class TranslateListFragment extends Fragment {
    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_translate_list, container, false);
        ButterKnife.bind(this,view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //<Удалить>
        MainTranslate mainTranslate = new MainTranslate();
        mainTranslate.setTranslate("Oleg");
        mainTranslate.setWord("Олег");
        List<MainTranslate> list = new ArrayList<>();
        list.add(mainTranslate);
        //</Удалить>
        mRecyclerView.setAdapter(new TranslateListAdapter(list,getActivity()));
        return view;
    }

    public static TranslateListFragment newInstance(){
        return new TranslateListFragment();
    }

}

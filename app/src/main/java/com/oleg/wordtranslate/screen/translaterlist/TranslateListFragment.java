package com.oleg.wordtranslate.screen.translaterlist;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.oleg.wordtranslate.R;
import com.oleg.wordtranslate.model.TranslateDao;
import com.oleg.wordtranslate.model.TranslateLab;
import com.oleg.wordtranslate.screen.translateedit.TranslateEdit;
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setTitle("Список переводов");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_translate_list, container, false);
        ButterKnife.bind(this,view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
        updateUI();
        mFloatingActionButton.setOnClickListener(v -> {
            Intent intent = TranslateActivity.newIntent(getActivity());
            startActivity(intent);
        });
        return view;
    }

    public void updateUI() {
        TranslateLab mTranslateLab = new TranslateLab(getActivity().getApplication());
        List<TranslateDao> translateDaoList = mTranslateLab.loadTranslate();

        mAdapter = new TranslateListAdapter(translateDaoList, getActivity(),this);
        mRecyclerView.setAdapter(mAdapter);

        updateSubtitle();

    }

    private void updateSubtitle(){
        TranslateLab translateLab = new TranslateLab(getActivity().getApplication());
        int translateCount = translateLab.loadTranslate().size();
        @SuppressLint("StringFormatMatches") String subtitle = getString(R.string.subtitle_format,translateCount);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setSubtitle(subtitle);
    }

    public static TranslateListFragment newInstance(){
        return new TranslateListFragment();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_translator_list_fragment,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_list_fragment_refresh:
                updateUI();
        }
        return true;
    }
}

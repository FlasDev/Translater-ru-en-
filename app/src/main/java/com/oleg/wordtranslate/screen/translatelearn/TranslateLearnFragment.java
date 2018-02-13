package com.oleg.wordtranslate.screen.translatelearn;


import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.oleg.wordtranslate.R;
import com.oleg.wordtranslate.model.TranslateDao;
import com.oleg.wordtranslate.model.TranslateLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TranslateLearnFragment extends Fragment {
    private static final String LOG = "myLogs";
    private static final String SAVE_TRUE_ANSWER = "true_answer";
    private static final String SAVE_FALSE_ANSWER = "false_answer";
    private DividerItemDecoration dividerItemDecoration;
    private TranslateDao mTrueAnswerDao;
    private TranslateLab translateLab;
    private int countTrueAnswer;
    private int countFalseAnswer;
    @BindView(R.id.recycler_view_translate_learn) RecyclerView mRecyclerView;
    @BindView(R.id.fragment_learn_textWord) TextView mTextWord;
    @BindView(R.id.fragment_learn_textTranslate) TextView mTextTranslate;
    @BindView(R.id.translate_learn_true_answer) TextView mTrueAnswer;
    @BindView(R.id.translate_learn_false_answer) TextView mFalseAnswer;

    private TranslateLearnAdapter mAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(true);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setTitle("Изучение слов");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_translate_learn, container, false);
        ButterKnife.bind(this,view);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
         mRecyclerView.setLayoutManager(layoutManager);
        dividerItemDecoration = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL));
        updateUI();
        CheckBox checkBox = view.findViewById(R.id.fragment_learn_checkbox);
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                mTextTranslate.setVisibility(View.VISIBLE);
            }else mTextTranslate.setVisibility(View.INVISIBLE);
        });
        countTrueAnswer = 0;
        countFalseAnswer = 0;
        return view;
    }

    public void updateUI() {
        List<TranslateDao> mList = new ArrayList<>();
         translateLab = new TranslateLab(getActivity().getApplication());
        int countWord = translateLab.loadTranslate().size();
        if(checkWordCount(countWord)) {
            long randomWord = 1 + (int) (Math.random() * countWord);
            mTrueAnswerDao = translateLab.loadSingleTranslate(randomWord);
            mTextWord.setText(mTrueAnswerDao.getTranslate());
            mTextTranslate.setText(mTrueAnswerDao.getName());
            mList.add(mTrueAnswerDao);
            loadLeftAnswer();
        }
    }

    public void loadLeftAnswer(){
        List<TranslateDao> mList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            TranslateDao translateDao1 = translateLab.loadSingleTranslate(1 + (int) (Math.random() *translateLab.loadTranslate().size()));
            mList.add(translateDao1);
        }
        mList.add(mTrueAnswerDao);
        Collections.shuffle(mList);
        updateAdapter(mList);
    }

    public void updateAdapter(List<TranslateDao> mList){
            mAdapter = new TranslateLearnAdapter(mList,getActivity(),this);
            mRecyclerView.setAdapter(mAdapter);
    }

    private boolean checkWordCount(int countWord) {
        boolean b;
        if(countWord ==0){
            b = false;
            Toast.makeText(getContext(), R.string.add_word_to_learn,Toast.LENGTH_SHORT).show();
        }else b = true;

        return b;
    }

    public static TranslateLearnFragment newInstance(){
        return new TranslateLearnFragment();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    public boolean isTrueAnswer(String answer,View view){
        boolean b;
        if(mTrueAnswerDao.getName() == answer){
            mTrueAnswer.setText(getString(R.string.count_true_answer,String.valueOf(++countTrueAnswer)));
            view.setBackgroundColor(Color.GREEN);
            b =  true;
        }else {
            view.setBackgroundColor(Color.RED);
            mFalseAnswer.setText(getString(R.string.count_false_answer,String.valueOf(++countFalseAnswer)));
            b = false;
        }
        return b;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}

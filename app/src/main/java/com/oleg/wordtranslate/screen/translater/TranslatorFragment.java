package com.oleg.wordtranslate.screen.translater;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.oleg.wordtranslate.R;
import com.oleg.wordtranslate.model.MainTranslate;
import com.oleg.wordtranslate.model.TranslateLab;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oleg on 02.02.2018.
 */

public class TranslatorFragment extends Fragment {
    private TranslateLab mTranslateLab;
    @BindView(R.id.fragment_translator_input_word) TextInputEditText mWordField;
    @BindView(R.id.fragment_translator_input_translate) TextInputEditText mTranslateField;
    @BindView(R.id.fragment_translator_button_translate) Button mTranslateButton;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
        mTranslateLab = new TranslateLab(getActivity());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_translator, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    public static TranslatorFragment newInstance(){
        return new TranslatorFragment();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.translator_fragment,menu);
    }

    @Override
    public void onPause() {
        super.onPause();
        //<Удалить>
        MainTranslate mainTranslate = new MainTranslate();
        mainTranslate.setTranslate(String.valueOf(mWordField.getText()));
        mainTranslate.setWord(String.valueOf(mTranslateField.getText()));
        mTranslateLab.addTranslate(mainTranslate);
        //</Удалить>
    }
}

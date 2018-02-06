package com.oleg.wordtranslate.screen.translater;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.oleg.wordtranslate.R;
import com.oleg.wordtranslate.model.TranslateDao;
import com.oleg.wordtranslate.model.TranslateLab;
import com.oleg.wordtranslate.screen.translaterlist.TranlateListActivity;

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
        mTranslateLab = new TranslateLab(getActivity().getApplication());
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setTitle("Добавление");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_translator, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public static TranslatorFragment newInstance(){
        return new TranslatorFragment();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_translator_fragment,menu);

}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean b = false;
        String text = mWordField.getText().toString();
        String translate = mTranslateField.getText().toString();
        switch (item.getItemId()){
            case R.id.menu_translator_done:
                if(checkIncorrectInput(text,translate)) {
                    mTranslateLab.addTranslate(new TranslateDao(mTranslateLab.getNextIdTranslate(), text, translate));
                    b = true;
                }else {
                    b = false;
                }

            default:
                Intent intent = TranlateListActivity.newIntent(getActivity());
                startActivity(intent);
        }
     return b;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public boolean checkIncorrectInput(String text, String translate){
        if(TextUtils.isEmpty(text) || TextUtils.isEmpty(translate)){
            Toast.makeText(getActivity(), "Введены некорректные данные. Повторите попытку!",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}

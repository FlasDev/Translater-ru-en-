package com.oleg.wordtranslate.screen.translater;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.oleg.wordtranslate.R;
import com.oleg.wordtranslate.database.TranslateDbDao;
import com.oleg.wordtranslate.model.TranslateDao;
import com.oleg.wordtranslate.model.TranslateLab;
import com.oleg.wordtranslate.screen.translaterlist.TranlateListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oleg on 02.02.2018.
 */

public class TranslatorFragment extends Fragment {
    private static final String LOG = "myLogs";
    private static final String TRANSLATE_ID = "translate_id";
    private Bundle mBundle;
    private TranslateLab mTranslateLab;
    private TranslateDao mTranslateDao;
    @BindView(R.id.fragment_translator_input_word) TextInputEditText mWordField;
    @BindView(R.id.fragment_translator_input_translate) TextInputEditText mTranslateField;
    @BindView(R.id.fragment_translator_button_translate) Button mTranslateButton;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
        mTranslateLab = new TranslateLab(getActivity().getApplication());
        mBundle = getArguments();
        if(mBundle != null)
        {

            long id = (long) getArguments().getSerializable(TRANSLATE_ID);
            mTranslateDao = mTranslateLab.loadSingleTranslate(id);
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_translator, container, false);
        ButterKnife.bind(this,view);
        if(mBundle != null) {
            mWordField.setText(mTranslateDao.getName());
            mTranslateField.setText(mTranslateDao.getTranslate());
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public static TranslatorFragment newInstance(long id){
        Bundle args = new Bundle();
        args.putSerializable(TRANSLATE_ID, id);

        TranslatorFragment translatorFragment = new TranslatorFragment();
        translatorFragment.setArguments(args);
        return translatorFragment;
    }

    public static TranslatorFragment newInstance(){
        return new TranslatorFragment();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.translator_fragment,menu);
        MenuItem menuDone = menu.findItem(R.id.menu_translator_done).setVisible(true);
        MenuItem menuEdit = menu.findItem(R.id.menu_translator_edit).setVisible(false);
        MenuItem menuDelete = menu.findItem(R.id.menu_translator_delete).setVisible(false);
        if(mBundle != null){
            menuDelete.setVisible(true);
            menuEdit.setVisible(true);
            menuDone.setVisible(false);
        }
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean b = false;
        String text = mWordField.getText().toString();
        String translate = mTranslateField.getText().toString();

        switch (item.getItemId()){

            case R.id.menu_translator_done:
                mTranslateLab.addTranslate(new TranslateDao(mTranslateLab.getNextIdTranslate(), text, translate));
                b = checkIncorrectInput(text,translate);
            case R.id.menu_translator_edit:
                mTranslateLab.updateSingleTranslate(new TranslateDao(mTranslateDao.getId(),text,translate));
                b = checkIncorrectInput(text,translate);
            case R.id.menu_translator_delete:
                mTranslateLab.deleteSingleTranslate(mTranslateDao.getId());
                b = true;
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

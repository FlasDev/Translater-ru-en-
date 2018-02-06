package com.oleg.wordtranslate.screen.translateedit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.oleg.wordtranslate.R;
import com.oleg.wordtranslate.model.TranslateDao;
import com.oleg.wordtranslate.model.TranslateLab;
import com.oleg.wordtranslate.screen.translaterlist.TranlateListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oleg on 05.02.2018.
 */

public class TranslateEditFragment extends Fragment {
    private static final String LOG ="myLogs";
    private static final String TRANSLATE_ID = "translate_id";
    private TranslateDao mTranslateDao;
    private TranslateLab mTranslateLab;
    @BindView(R.id.fragment_edit_translate_text) EditText mTextInputField;
    @BindView(R.id.fragment_edit_translate_translate) EditText mTranslateInputField;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
        mTranslateLab = new TranslateLab(getActivity().getApplication());
        long id = (long)getArguments().getSerializable(TRANSLATE_ID);
        mTranslateDao = mTranslateLab.loadSingleTranslate(id);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setTitle("Редактирование");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_translate_edit,container,false);
        ButterKnife.bind(this,view);
        mTextInputField.setText(mTranslateDao.getName());
        mTranslateInputField.setText(mTranslateDao.getTranslate());
        return view;
    }

    public static TranslateEditFragment newInstance(long id){
        Bundle args = new Bundle();
        args.putSerializable(TRANSLATE_ID,id);

        TranslateEditFragment translateEditFragment = new TranslateEditFragment();
        translateEditFragment.setArguments(args);
        return translateEditFragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_translator_edit_fragment,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean b = false;
        String text = mTextInputField.getText().toString();
        String translate = mTranslateInputField.getText().toString();
        switch (item.getItemId()){
            case R.id.menu_edit_fragment_edit:
                if(checkIncorrectInput(text,translate)) {
                    mTranslateLab.updateSingleTranslate(new TranslateDao(mTranslateDao.getId(), text, translate));
                    b = true;
                }
                break;
            case R.id.menu_edit_fragment_delete:
                mTranslateLab.deleteSingleTranslate(mTranslateDao.getId());
                b = true;
                break;
                default:
                    b  = super.onOptionsItemSelected(item);
        }
        Intent intent = TranlateListActivity.newIntent(getActivity());
        startActivity(intent);
        return b;
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

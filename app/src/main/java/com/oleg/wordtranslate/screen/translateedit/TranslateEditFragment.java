package com.oleg.wordtranslate.screen.translateedit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oleg.wordtranslate.R;

/**
 * Created by oleg on 05.02.2018.
 */

public class TranslateEditFragment extends Fragment {
    private static final String TRANSLATE_ID = "translate_id";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_translate_edit,container,false);
        return view;
    }

    public static TranslateEditFragment newInstance(long id){
        Bundle args = new Bundle();
        args.putSerializable(TRANSLATE_ID,id);

        TranslateEditFragment translateEditFragment = new TranslateEditFragment();
        translateEditFragment.setArguments(args);
        return translateEditFragment;
    }
}

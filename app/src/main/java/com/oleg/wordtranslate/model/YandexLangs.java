package com.oleg.wordtranslate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by oleg on 13.02.2018.
 */

public class YandexLangs {

    @SerializedName("dirs")
    @Expose
    private List<String> dirs = null;

    public List<String> getDirs() {
        return dirs;
    }

    public void setDirs(List<String> dirs) {
        this.dirs = dirs;
    }

}

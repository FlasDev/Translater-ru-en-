package com.oleg.wordtranslate.database;

/**
 * Created by oleg on 02.02.2018.
 */

public class TranslateDBSchema {
    public static final class TranslateTable{
        public static final String NAME = "translate";

        public static final class Colums{
            public static final String UUID = "uuid";
            public static final String TEXT = "text";
            public static final String TRANSLATE = "translate";
        }
    }
}

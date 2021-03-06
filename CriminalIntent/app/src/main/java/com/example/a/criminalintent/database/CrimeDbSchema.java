package com.example.a.criminalintent.database;

public class CrimeDbSchema {
    public static final class CrimeTable{
        public static final String NAME = "crimes";
        public static final class Cols{
            public static final String UUID = "UUID";
            public static final String TITLE = "TITLE";
            public static final String DATE = "DATE";
            public static final String SOLVED = "SOLVED";
            public static final String SUSPECT = "SUSPECT";
        }
    }
}

package com.example.a.criminalintent.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.a.criminalintent.database.CrimeDbSchema.CrimeTable.Cols;
import com.example.a.criminalintent.model.Crime;

public class CrimeCurserWrapper extends CursorWrapper {
    public CrimeCurserWrapper(Cursor cursor) {
        super(cursor);
    }
    public Crime getCrime(){
        String uuid = getString(getColumnIndex(Cols.UUID));
        String title = getString(getColumnIndex(Cols.TITLE));
        long date = getLong(getColumnIndex(Cols.DATE));
        int isSolved = getInt(getColumnIndex(Cols.SOLVED));
        String suspect = getString(getColumnIndex(Cols.SUSPECT));

        return new Crime(uuid, title, date, isSolved, suspect);

    }
}

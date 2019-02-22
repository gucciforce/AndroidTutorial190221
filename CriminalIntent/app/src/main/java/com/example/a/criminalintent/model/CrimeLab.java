package com.example.a.criminalintent.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.a.criminalintent.database.CrimeBaseHelper;
import com.example.a.criminalintent.database.CrimeDbSchema;
import com.example.a.criminalintent.database.CrimeDbSchema.CrimeTable;
import com.example.a.criminalintent.database.CrimeDbSchema.CrimeTable.Cols;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    //private List<Crime> mCrimes;
    private SQLiteDatabase mDatabase;
    private Context mContext;

    public List<Crime> getCrimes() {
        return new ArrayList<>();
    }
    public Crime getCrime(UUID id){
        /*
        for(Crime crime: mCrimes){
            if(crime.getId().equals(id)){
                return crime;
            }
        }
        */
        return null;
    }

    public static CrimeLab get(Context context){
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    public void addCrime(Crime c){
        ContentValues values =  getContentValues(c);
        mDatabase.insert(CrimeTable.NAME, null, values);
    }

    public void updateCrime(Crime c){
        ContentValues values = getContentValues(c);
        mDatabase.update(CrimeTable.NAME, values,Cols.UUID+ " = ?", new String[]{ c.getId().toString()});
    }

    private CrimeLab(Context context){
        /*
        for(int i=0; i<100; i++){
            Crime crime = new Crime();
            crime.setTitle("범죄 #"+i);
            crime.setSolved(i%2==0);
            mCrimes.add(crime);
        }
        */
        //mCrimes = new ArrayList<>();

        mContext = context;
        mDatabase = new CrimeBaseHelper(context).getWritableDatabase();
    }

    private static ContentValues getContentValues(Crime crime){
        ContentValues values = new ContentValues();
        values.put(Cols.UUID,crime.getId().toString());
        values.put(Cols.TITLE,crime.getTitle().toString());
        values.put(Cols.DATE,crime.getDate().getTime());
        values.put(Cols.SOLVED,crime.isSolved()? 1:0);

        return values;
    }

}
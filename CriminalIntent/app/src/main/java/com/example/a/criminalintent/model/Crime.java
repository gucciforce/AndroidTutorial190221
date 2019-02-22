package com.example.a.criminalintent.model;

import java.util.Date;
import java.util.UUID;

public class Crime {
        private UUID mId;
        private  String mTitle;
        private Date mData;
        private  boolean Solved;

        public Crime(){
            mId = UUID.randomUUID();
            mData = new Date();
        }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getData() {
        return mData;
    }

    public void setData(Date data) {
        mData = data;
    }

    public boolean isSolved() {
        return Solved;
    }

    public void setSolved(boolean solved) {
        Solved = solved;
    }
}

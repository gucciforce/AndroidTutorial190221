package com.example.a.beatboxmvvm;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BeatBoxActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return BeatBoxFragment.ngetInstance();
    }

}

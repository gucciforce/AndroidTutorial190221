package com.example.a.beatbox_mvvm.model;

import android.media.SoundPool;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SoundViewModelTest {
    private BeatBox mBeatBox;
    private Sound mSound;
    private SoundViewModel mSubject;

    @Before
    public void setUp() throws Exception {
        mBeatBox = mock(BeatBox.class);
        mSound = new Sound("assertPath");
        mSubject = new SoundViewModel(mBeatBox);
        mSubject.setSound(mSound);
    }
    @Test
    public void exposesSoundNameAsTitle(){
        //결과가 같은지 확인하는 테스트
        assertThat(mSubject.getTitle(),is(mSound.getName()));
    }

    @Test
    public void callsBeatBoxPlayOnButtonClicked(){
        mSubject.onButtonClicked();

        //verify(mBeatBox).play(mSound);
        verify(mBeatBox);
        mBeatBox.play(mSound);
    }


}
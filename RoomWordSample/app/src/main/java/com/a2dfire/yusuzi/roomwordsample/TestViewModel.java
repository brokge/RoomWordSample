package com.a2dfire.yusuzi.roomwordsample;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

public class TestViewModel extends AndroidViewModel {

    private MutableLiveData<Word> mWord;

    public TestViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Word> getWord() {
        if (mWord == null) {
            mWord = new MutableLiveData<>();
        }
        return mWord;
    }
}

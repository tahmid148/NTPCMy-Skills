package com.ntpc.myskills.ui.enrol;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EnrolViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public EnrolViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}
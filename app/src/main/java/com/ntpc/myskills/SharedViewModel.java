package com.ntpc.myskills;

import android.content.ClipData;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Fragment> selected = new MutableLiveData<>();

    public void select(Fragment item) {
        selected.setValue(item);
    }

    public LiveData<Fragment> getSelected() {
        return selected;
    }
}
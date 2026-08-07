package com.box.android.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/* JADX INFO: loaded from: classes13.dex */
public class ActionbarTitleVM extends ViewModel {
    MutableLiveData<String> mTitle = new MutableLiveData<>();
    MutableLiveData<String> mSubtitle = new MutableLiveData<>();

    public LiveData<String> getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle.postValue(str);
    }

    public LiveData<String> getSubtitle() {
        return this.mSubtitle;
    }

    public void setSubtitle(String str) {
        this.mSubtitle.postValue(str);
    }
}

package com.box.android.vm;

import com.box.androidsdk.content.BoxException;

/* JADX INFO: loaded from: classes13.dex */
public class PresenterData<T> {
    public static final int NO_MESSAGE = -1;
    protected T mData;
    protected Exception mException;
    protected boolean mIsHandled;
    protected int mStrRes;

    public PresenterData() {
        this.mStrRes = -1;
    }

    public PresenterData(T t, int i) {
        this.mData = t;
        this.mStrRes = i;
    }

    public PresenterData(T t, int i, BoxException boxException) {
        this.mData = t;
        this.mStrRes = i;
        this.mException = boxException;
    }

    public void success(T t) {
        this.mData = t;
        this.mStrRes = -1;
    }

    public void success(T t, int i) {
        this.mData = t;
        this.mStrRes = i;
        this.mException = null;
    }

    public void failure(int i, Exception exc) {
        this.mData = null;
        this.mStrRes = i;
        this.mException = exc;
    }

    public void failure(T t, int i, Exception exc) {
        this.mData = t;
        this.mStrRes = i;
        this.mException = exc;
    }

    public boolean isSuccess() {
        return this.mException == null;
    }

    public T getData() {
        this.mIsHandled = true;
        return this.mData;
    }

    public int getStrCode() {
        this.mIsHandled = true;
        return this.mStrRes;
    }

    public Exception getException() {
        return this.mException;
    }

    public void setException(Exception exc) {
        this.mException = exc;
    }

    public boolean isHandled() {
        return this.mIsHandled;
    }
}

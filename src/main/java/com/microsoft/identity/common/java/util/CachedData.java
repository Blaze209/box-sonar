package com.microsoft.identity.common.java.util;

/* JADX INFO: loaded from: classes14.dex */
public abstract class CachedData<T> {
    private T mData;

    public void setData(T t) {
        this.mData = t;
    }

    public T getData() {
        return this.mData;
    }

    public void clear() {
        this.mData = null;
    }
}

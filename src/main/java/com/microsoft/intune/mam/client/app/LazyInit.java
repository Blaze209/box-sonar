package com.microsoft.intune.mam.client.app;

/* JADX INFO: loaded from: classes3.dex */
public class LazyInit<T> {
    Provider<T> mProvider;
    volatile T mVal = null;

    public interface Provider<T> {
        T get();
    }

    public LazyInit(Provider<T> provider) {
        this.mProvider = provider;
    }

    public T get() {
        if (this.mVal != null) {
            return this.mVal;
        }
        synchronized (this) {
            if (this.mVal == null) {
                this.mVal = this.mProvider.get();
            }
        }
        return this.mVal;
    }
}

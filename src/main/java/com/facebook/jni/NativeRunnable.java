package com.facebook.jni;

/* JADX INFO: loaded from: classes13.dex */
public class NativeRunnable implements Runnable {
    private final HybridData mHybridData;

    @Override // java.lang.Runnable
    public native void run();

    private NativeRunnable(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}

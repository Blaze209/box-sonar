package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeCacheFilePutOptions {
    final boolean mCanMoveFile;

    public NativeCacheFilePutOptions(boolean z) {
        this.mCanMoveFile = z;
    }

    public boolean getCanMoveFile() {
        return this.mCanMoveFile;
    }

    public String toString() {
        return "NativeCacheFilePutOptions{mCanMoveFile=" + this.mCanMoveFile + "}";
    }
}

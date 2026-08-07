package com.pspdfkit.internal.jni;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeFormRemovalResult {
    final String mErrorString;
    final boolean mHasError;
    final ArrayList<String> mRemovedFieldFQNs;

    public NativeFormRemovalResult(boolean z, String str, ArrayList<String> arrayList) {
        this.mHasError = z;
        this.mErrorString = str;
        this.mRemovedFieldFQNs = arrayList;
    }

    public String getErrorString() {
        return this.mErrorString;
    }

    public boolean getHasError() {
        return this.mHasError;
    }

    public ArrayList<String> getRemovedFieldFQNs() {
        return this.mRemovedFieldFQNs;
    }

    public String toString() {
        return "NativeFormRemovalResult{mHasError=" + this.mHasError + ",mErrorString=" + this.mErrorString + ",mRemovedFieldFQNs=" + this.mRemovedFieldFQNs + "}";
    }
}

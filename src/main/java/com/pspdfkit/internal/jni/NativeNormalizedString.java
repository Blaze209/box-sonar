package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeNormalizedString {
    final int mNewLength;
    final int mOldLength;
    final String mValue;

    public NativeNormalizedString(String str, int i, int i2) {
        this.mValue = str;
        this.mOldLength = i;
        this.mNewLength = i2;
    }

    public int getNewLength() {
        return this.mNewLength;
    }

    public int getOldLength() {
        return this.mOldLength;
    }

    public String getValue() {
        return this.mValue;
    }

    public String toString() {
        return "NativeNormalizedString{mValue=" + this.mValue + ",mOldLength=" + this.mOldLength + ",mNewLength=" + this.mNewLength + "}";
    }
}

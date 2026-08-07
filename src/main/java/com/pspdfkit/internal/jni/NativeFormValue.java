package com.pspdfkit.internal.jni;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeFormValue {
    final boolean mIsName;
    final ArrayList<String> mValues;

    public NativeFormValue(boolean z, ArrayList<String> arrayList) {
        this.mIsName = z;
        this.mValues = arrayList;
    }

    public boolean getIsName() {
        return this.mIsName;
    }

    public ArrayList<String> getValues() {
        return this.mValues;
    }

    public String toString() {
        return "NativeFormValue{mIsName=" + this.mIsName + ",mValues=" + this.mValues + "}";
    }
}

package com.pspdfkit.internal.jni;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeTextRange {
    final int mIndex;
    final int mLength;
    final ArrayList<NativeRectDescriptor> mMarkupRects;
    final ArrayList<NativeRectDescriptor> mRects;

    public NativeTextRange(int i, int i2, ArrayList<NativeRectDescriptor> arrayList, ArrayList<NativeRectDescriptor> arrayList2) {
        this.mIndex = i;
        this.mLength = i2;
        this.mRects = arrayList;
        this.mMarkupRects = arrayList2;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public int getLength() {
        return this.mLength;
    }

    public ArrayList<NativeRectDescriptor> getMarkupRects() {
        return this.mMarkupRects;
    }

    public ArrayList<NativeRectDescriptor> getRects() {
        return this.mRects;
    }

    public String toString() {
        return "NativeTextRange{mIndex=" + this.mIndex + ",mLength=" + this.mLength + ",mRects=" + this.mRects + ",mMarkupRects=" + this.mMarkupRects + "}";
    }
}

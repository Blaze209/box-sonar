package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeJSPrintParams {
    final Integer mEnd;
    final boolean mPrintAnnotations;
    final boolean mPrintAsImage;
    final boolean mReverse;
    final boolean mShrinkToFit;
    final boolean mSilent;
    final Integer mStart;
    final Boolean mUi;

    public NativeJSPrintParams(Boolean bool, Integer num, Integer num2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.mUi = bool;
        this.mStart = num;
        this.mEnd = num2;
        this.mSilent = z;
        this.mShrinkToFit = z2;
        this.mPrintAsImage = z3;
        this.mReverse = z4;
        this.mPrintAnnotations = z5;
    }

    public Integer getEnd() {
        return this.mEnd;
    }

    public boolean getPrintAnnotations() {
        return this.mPrintAnnotations;
    }

    public boolean getPrintAsImage() {
        return this.mPrintAsImage;
    }

    public boolean getReverse() {
        return this.mReverse;
    }

    public boolean getShrinkToFit() {
        return this.mShrinkToFit;
    }

    public boolean getSilent() {
        return this.mSilent;
    }

    public Integer getStart() {
        return this.mStart;
    }

    public Boolean getUi() {
        return this.mUi;
    }

    public String toString() {
        return "NativeJSPrintParams{mUi=" + this.mUi + ",mStart=" + this.mStart + ",mEnd=" + this.mEnd + ",mSilent=" + this.mSilent + ",mShrinkToFit=" + this.mShrinkToFit + ",mPrintAsImage=" + this.mPrintAsImage + ",mReverse=" + this.mReverse + ",mPrintAnnotations=" + this.mPrintAnnotations + "}";
    }
}

package com.pspdfkit.internal.jni;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeParagraphResult {
    final ArrayList<NativeParagraph> mParagraphs;
    final NativeResult mResult;

    public NativeParagraphResult(NativeResult nativeResult, ArrayList<NativeParagraph> arrayList) {
        this.mResult = nativeResult;
        this.mParagraphs = arrayList;
    }

    public ArrayList<NativeParagraph> getParagraphs() {
        return this.mParagraphs;
    }

    public NativeResult getResult() {
        return this.mResult;
    }

    public String toString() {
        return "NativeParagraphResult{mResult=" + this.mResult + ",mParagraphs=" + this.mParagraphs + "}";
    }
}

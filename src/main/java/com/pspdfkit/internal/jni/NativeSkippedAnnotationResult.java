package com.pspdfkit.internal.jni;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeSkippedAnnotationResult {
    final NativeResult mResult;
    final ArrayList<NativeAnnotation> mSkippedAnnotations;

    public NativeSkippedAnnotationResult(NativeResult nativeResult, ArrayList<NativeAnnotation> arrayList) {
        this.mResult = nativeResult;
        this.mSkippedAnnotations = arrayList;
    }

    public NativeResult getResult() {
        return this.mResult;
    }

    public ArrayList<NativeAnnotation> getSkippedAnnotations() {
        return this.mSkippedAnnotations;
    }

    public String toString() {
        return "NativeSkippedAnnotationResult{mResult=" + this.mResult + ",mSkippedAnnotations=" + this.mSkippedAnnotations + "}";
    }
}

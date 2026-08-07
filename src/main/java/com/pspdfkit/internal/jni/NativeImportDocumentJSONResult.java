package com.pspdfkit.internal.jni;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeImportDocumentJSONResult {
    final ArrayList<NativeAnnotation> mAddedAnnotations;
    final ArrayList<Long> mRemovedAnnotationObjectNumbers;
    final NativeResult mResult;
    final ArrayList<NativeAnnotation> mUpdatedAnnotations;

    public NativeImportDocumentJSONResult(NativeResult nativeResult, ArrayList<NativeAnnotation> arrayList, ArrayList<NativeAnnotation> arrayList2, ArrayList<Long> arrayList3) {
        this.mResult = nativeResult;
        this.mAddedAnnotations = arrayList;
        this.mUpdatedAnnotations = arrayList2;
        this.mRemovedAnnotationObjectNumbers = arrayList3;
    }

    public ArrayList<NativeAnnotation> getAddedAnnotations() {
        return this.mAddedAnnotations;
    }

    public ArrayList<Long> getRemovedAnnotationObjectNumbers() {
        return this.mRemovedAnnotationObjectNumbers;
    }

    public NativeResult getResult() {
        return this.mResult;
    }

    public ArrayList<NativeAnnotation> getUpdatedAnnotations() {
        return this.mUpdatedAnnotations;
    }

    public String toString() {
        return "NativeImportDocumentJSONResult{mResult=" + this.mResult + ",mAddedAnnotations=" + this.mAddedAnnotations + ",mUpdatedAnnotations=" + this.mUpdatedAnnotations + ",mRemovedAnnotationObjectNumbers=" + this.mRemovedAnnotationObjectNumbers + "}";
    }
}

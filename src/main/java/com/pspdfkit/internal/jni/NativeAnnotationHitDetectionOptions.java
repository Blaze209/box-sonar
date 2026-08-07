package com.pspdfkit.internal.jni;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeAnnotationHitDetectionOptions {
    final ArrayList<NativeAnnotationType> mAnnotationTypes;
    final float mMinAnnotationSize;
    final boolean mUsePathBasedHitDetection;

    public NativeAnnotationHitDetectionOptions(ArrayList<NativeAnnotationType> arrayList, float f, boolean z) {
        this.mAnnotationTypes = arrayList;
        this.mMinAnnotationSize = f;
        this.mUsePathBasedHitDetection = z;
    }

    public ArrayList<NativeAnnotationType> getAnnotationTypes() {
        return this.mAnnotationTypes;
    }

    public float getMinAnnotationSize() {
        return this.mMinAnnotationSize;
    }

    public boolean getUsePathBasedHitDetection() {
        return this.mUsePathBasedHitDetection;
    }

    public String toString() {
        return "NativeAnnotationHitDetectionOptions{mAnnotationTypes=" + this.mAnnotationTypes + ",mMinAnnotationSize=" + this.mMinAnnotationSize + ",mUsePathBasedHitDetection=" + this.mUsePathBasedHitDetection + "}";
    }
}

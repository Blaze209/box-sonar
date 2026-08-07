package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeAnnotationMapping {
    final NativeAnnotation mFirst;
    final NativeAnnotation mSecond;

    public NativeAnnotationMapping(NativeAnnotation nativeAnnotation, NativeAnnotation nativeAnnotation2) {
        this.mFirst = nativeAnnotation;
        this.mSecond = nativeAnnotation2;
    }

    public NativeAnnotation getFirst() {
        return this.mFirst;
    }

    public NativeAnnotation getSecond() {
        return this.mSecond;
    }

    public String toString() {
        return "NativeAnnotationMapping{mFirst=" + this.mFirst + ",mSecond=" + this.mSecond + "}";
    }
}

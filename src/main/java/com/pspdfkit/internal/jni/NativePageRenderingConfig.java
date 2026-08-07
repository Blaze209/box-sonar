package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public final class NativePageRenderingConfig {
    final Integer mBackgroundColor;
    final ArrayList<NativeAnnotationType> mExcludeAnnotationTypes;
    final ArrayList<Integer> mExcludeAnnotations;
    final EnumSet<NativePageRenderingFlags> mFlags;
    final NativeFormRenderingConfig mFormRenderingConfig;
    final byte mRotation;

    public NativePageRenderingConfig(Integer num, NativeFormRenderingConfig nativeFormRenderingConfig, ArrayList<Integer> arrayList, ArrayList<NativeAnnotationType> arrayList2, byte b, EnumSet<NativePageRenderingFlags> enumSet) {
        this.mBackgroundColor = num;
        this.mFormRenderingConfig = nativeFormRenderingConfig;
        this.mExcludeAnnotations = arrayList;
        this.mExcludeAnnotationTypes = arrayList2;
        this.mRotation = b;
        this.mFlags = enumSet;
    }

    public Integer getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public ArrayList<NativeAnnotationType> getExcludeAnnotationTypes() {
        return this.mExcludeAnnotationTypes;
    }

    public ArrayList<Integer> getExcludeAnnotations() {
        return this.mExcludeAnnotations;
    }

    public EnumSet<NativePageRenderingFlags> getFlags() {
        return this.mFlags;
    }

    public NativeFormRenderingConfig getFormRenderingConfig() {
        return this.mFormRenderingConfig;
    }

    public byte getRotation() {
        return this.mRotation;
    }

    public String toString() {
        return "NativePageRenderingConfig{mBackgroundColor=" + this.mBackgroundColor + ",mFormRenderingConfig=" + this.mFormRenderingConfig + ",mExcludeAnnotations=" + this.mExcludeAnnotations + ",mExcludeAnnotationTypes=" + this.mExcludeAnnotationTypes + ",mRotation=" + ((int) this.mRotation) + ",mFlags=" + this.mFlags + "}";
    }
}

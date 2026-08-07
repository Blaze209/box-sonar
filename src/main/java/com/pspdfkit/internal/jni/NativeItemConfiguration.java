package com.pspdfkit.internal.jni;

import android.graphics.Matrix;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeItemConfiguration {
    final NativeImage mImage;
    final Matrix mItemMatrix;
    final NativeItemRelativePosition mItemRelativePosition;
    final NativeItemZPosition mItemZPosition;
    final NativeDataDescriptor mPDFDataDescriptor;
    final Integer mPDFDataPageIndex;

    public NativeItemConfiguration(NativeImage nativeImage, NativeDataDescriptor nativeDataDescriptor, Integer num, NativeItemRelativePosition nativeItemRelativePosition, NativeItemZPosition nativeItemZPosition, Matrix matrix) {
        this.mImage = nativeImage;
        this.mPDFDataDescriptor = nativeDataDescriptor;
        this.mPDFDataPageIndex = num;
        this.mItemRelativePosition = nativeItemRelativePosition;
        this.mItemZPosition = nativeItemZPosition;
        this.mItemMatrix = matrix;
    }

    public NativeImage getImage() {
        return this.mImage;
    }

    public Matrix getItemMatrix() {
        return this.mItemMatrix;
    }

    public NativeItemRelativePosition getItemRelativePosition() {
        return this.mItemRelativePosition;
    }

    public NativeItemZPosition getItemZPosition() {
        return this.mItemZPosition;
    }

    public NativeDataDescriptor getPDFDataDescriptor() {
        return this.mPDFDataDescriptor;
    }

    public Integer getPDFDataPageIndex() {
        return this.mPDFDataPageIndex;
    }

    public String toString() {
        return "NativeItemConfiguration{mImage=" + this.mImage + ",mPDFDataDescriptor=" + this.mPDFDataDescriptor + ",mPDFDataPageIndex=" + this.mPDFDataPageIndex + ",mItemRelativePosition=" + this.mItemRelativePosition + ",mItemZPosition=" + this.mItemZPosition + ",mItemMatrix=" + this.mItemMatrix + "}";
    }
}

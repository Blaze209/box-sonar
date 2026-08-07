package com.pspdfkit.internal.jni;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.pspdfkit.utils.Size;

/* JADX INFO: loaded from: classes3.dex */
public final class NativePageInfo {
    final boolean mAllowAnnotationCreation;
    final RectF mBbox;
    final Matrix mInversePageMatrix;
    final Matrix mPageMatrix;
    final byte mRotation;
    final byte mRotationOffset;
    final Size mSize;
    final RectF mUntransformedBbox;

    public NativePageInfo(Size size, RectF rectF, RectF rectF2, byte b, byte b2, Matrix matrix, Matrix matrix2, boolean z) {
        this.mSize = size;
        this.mBbox = rectF;
        this.mUntransformedBbox = rectF2;
        this.mRotation = b;
        this.mRotationOffset = b2;
        this.mPageMatrix = matrix;
        this.mInversePageMatrix = matrix2;
        this.mAllowAnnotationCreation = z;
    }

    public boolean getAllowAnnotationCreation() {
        return this.mAllowAnnotationCreation;
    }

    public RectF getBbox() {
        return this.mBbox;
    }

    public Matrix getInversePageMatrix() {
        return this.mInversePageMatrix;
    }

    public Matrix getPageMatrix() {
        return this.mPageMatrix;
    }

    public byte getRotation() {
        return this.mRotation;
    }

    public byte getRotationOffset() {
        return this.mRotationOffset;
    }

    public Size getSize() {
        return this.mSize;
    }

    public RectF getUntransformedBbox() {
        return this.mUntransformedBbox;
    }

    public String toString() {
        return "NativePageInfo{mSize=" + this.mSize + ",mBbox=" + this.mBbox + ",mUntransformedBbox=" + this.mUntransformedBbox + ",mRotation=" + ((int) this.mRotation) + ",mRotationOffset=" + ((int) this.mRotationOffset) + ",mPageMatrix=" + this.mPageMatrix + ",mInversePageMatrix=" + this.mInversePageMatrix + ",mAllowAnnotationCreation=" + this.mAllowAnnotationCreation + "}";
    }
}

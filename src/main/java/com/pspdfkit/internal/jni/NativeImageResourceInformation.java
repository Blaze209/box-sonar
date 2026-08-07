package com.pspdfkit.internal.jni;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.pspdfkit.utils.Size;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeImageResourceInformation {
    final boolean mHasAlpha;
    final Matrix mMatrix;
    final Size mOriginalSize;
    final RectF mRect;

    public NativeImageResourceInformation(RectF rectF, Size size, Matrix matrix, boolean z) {
        this.mRect = rectF;
        this.mOriginalSize = size;
        this.mMatrix = matrix;
        this.mHasAlpha = z;
    }

    public boolean getHasAlpha() {
        return this.mHasAlpha;
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Size getOriginalSize() {
        return this.mOriginalSize;
    }

    public RectF getRect() {
        return this.mRect;
    }

    public String toString() {
        return "NativeImageResourceInformation{mRect=" + this.mRect + ",mOriginalSize=" + this.mOriginalSize + ",mMatrix=" + this.mMatrix + ",mHasAlpha=" + this.mHasAlpha + "}";
    }
}

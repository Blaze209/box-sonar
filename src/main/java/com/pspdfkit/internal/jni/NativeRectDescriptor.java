package com.pspdfkit.internal.jni;

import android.graphics.RectF;
import com.pspdfkit.datastructures.Range;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeRectDescriptor {
    final Range mRange;
    final RectF mRect;

    public NativeRectDescriptor(RectF rectF, Range range) {
        this.mRect = rectF;
        this.mRange = range;
    }

    public Range getRange() {
        return this.mRange;
    }

    public RectF getRect() {
        return this.mRect;
    }

    public String toString() {
        return "NativeRectDescriptor{mRect=" + this.mRect + ",mRange=" + this.mRange + "}";
    }
}

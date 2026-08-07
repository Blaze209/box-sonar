package com.pspdfkit.internal.jni;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeJSButtonImportIconFormElementInfo {
    final int mFormAnnotationId;
    final RectF mFormBbox;
    final int mFormPageIndex;

    public NativeJSButtonImportIconFormElementInfo(int i, RectF rectF, int i2) {
        this.mFormPageIndex = i;
        this.mFormBbox = rectF;
        this.mFormAnnotationId = i2;
    }

    public int getFormAnnotationId() {
        return this.mFormAnnotationId;
    }

    public RectF getFormBbox() {
        return this.mFormBbox;
    }

    public int getFormPageIndex() {
        return this.mFormPageIndex;
    }

    public String toString() {
        return "NativeJSButtonImportIconFormElementInfo{mFormPageIndex=" + this.mFormPageIndex + ",mFormBbox=" + this.mFormBbox + ",mFormAnnotationId=" + this.mFormAnnotationId + "}";
    }
}

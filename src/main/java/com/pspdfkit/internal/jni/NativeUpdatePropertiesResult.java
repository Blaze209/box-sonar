package com.pspdfkit.internal.jni;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeUpdatePropertiesResult {
    final String mErrorString;
    final boolean mHasError;
    final RectF mUpdatedBoundingBox;

    public NativeUpdatePropertiesResult(boolean z, String str, RectF rectF) {
        this.mHasError = z;
        this.mErrorString = str;
        this.mUpdatedBoundingBox = rectF;
    }

    public String getErrorString() {
        return this.mErrorString;
    }

    public boolean getHasError() {
        return this.mHasError;
    }

    public RectF getUpdatedBoundingBox() {
        return this.mUpdatedBoundingBox;
    }

    public String toString() {
        return "NativeUpdatePropertiesResult{mHasError=" + this.mHasError + ",mErrorString=" + this.mErrorString + ",mUpdatedBoundingBox=" + this.mUpdatedBoundingBox + "}";
    }
}

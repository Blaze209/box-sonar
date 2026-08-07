package com.pspdfkit.internal.jni;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeParagraph {
    final RectF mRect;
    final String mText;

    public NativeParagraph(String str, RectF rectF) {
        this.mText = str;
        this.mRect = rectF;
    }

    public RectF getRect() {
        return this.mRect;
    }

    public String getText() {
        return this.mText;
    }

    public String toString() {
        return "NativeParagraph{mText=" + this.mText + ",mRect=" + this.mRect + "}";
    }
}

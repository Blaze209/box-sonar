package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeRedactionPreset {
    final Integer mFillColor;
    final Integer mOutlineColor;
    final String mOverlayText;
    final boolean mRepeatOverlayText;

    public NativeRedactionPreset(Integer num, Integer num2, String str, boolean z) {
        this.mFillColor = num;
        this.mOutlineColor = num2;
        this.mOverlayText = str;
        this.mRepeatOverlayText = z;
    }

    public Integer getFillColor() {
        return this.mFillColor;
    }

    public Integer getOutlineColor() {
        return this.mOutlineColor;
    }

    public String getOverlayText() {
        return this.mOverlayText;
    }

    public boolean getRepeatOverlayText() {
        return this.mRepeatOverlayText;
    }

    public String toString() {
        return "NativeRedactionPreset{mFillColor=" + this.mFillColor + ",mOutlineColor=" + this.mOutlineColor + ",mOverlayText=" + this.mOverlayText + ",mRepeatOverlayText=" + this.mRepeatOverlayText + "}";
    }
}

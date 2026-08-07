package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeFormRenderingConfig {
    final Integer mInteractiveFormHighlightColor;
    final Integer mRequiredFormBorderColor;
    final Integer mSelectedListBoxHighlightColor;
    final boolean mShouldRenderSignHereOverlay;
    final Integer mSignHereOverlayBackgroundColor;

    public NativeFormRenderingConfig(Integer num, Integer num2, Integer num3, Integer num4, boolean z) {
        this.mInteractiveFormHighlightColor = num;
        this.mRequiredFormBorderColor = num2;
        this.mSignHereOverlayBackgroundColor = num3;
        this.mSelectedListBoxHighlightColor = num4;
        this.mShouldRenderSignHereOverlay = z;
    }

    public Integer getInteractiveFormHighlightColor() {
        return this.mInteractiveFormHighlightColor;
    }

    public Integer getRequiredFormBorderColor() {
        return this.mRequiredFormBorderColor;
    }

    public Integer getSelectedListBoxHighlightColor() {
        return this.mSelectedListBoxHighlightColor;
    }

    public boolean getShouldRenderSignHereOverlay() {
        return this.mShouldRenderSignHereOverlay;
    }

    public Integer getSignHereOverlayBackgroundColor() {
        return this.mSignHereOverlayBackgroundColor;
    }

    public String toString() {
        return "NativeFormRenderingConfig{mInteractiveFormHighlightColor=" + this.mInteractiveFormHighlightColor + ",mRequiredFormBorderColor=" + this.mRequiredFormBorderColor + ",mSignHereOverlayBackgroundColor=" + this.mSignHereOverlayBackgroundColor + ",mSelectedListBoxHighlightColor=" + this.mSelectedListBoxHighlightColor + ",mShouldRenderSignHereOverlay=" + this.mShouldRenderSignHereOverlay + "}";
    }
}

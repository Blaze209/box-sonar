package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeAnnotationRenderingConfig {
    final boolean mDisablePlatformApstreamGenerator;
    final boolean mDontRenderApstream;
    final boolean mDrawRedactAsRedacted;
    final NativeFormRenderingConfig mFormRenderingConfig;
    final boolean mRenderGrayscale;
    final boolean mRenderInvertedColors;
    final boolean mShouldApplyPageRotation;
    final boolean mShouldDrawFormHighlights;

    public NativeAnnotationRenderingConfig(NativeFormRenderingConfig nativeFormRenderingConfig, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.mFormRenderingConfig = nativeFormRenderingConfig;
        this.mShouldDrawFormHighlights = z;
        this.mRenderGrayscale = z2;
        this.mRenderInvertedColors = z3;
        this.mDontRenderApstream = z4;
        this.mShouldApplyPageRotation = z5;
        this.mDisablePlatformApstreamGenerator = z6;
        this.mDrawRedactAsRedacted = z7;
    }

    public boolean getDisablePlatformApstreamGenerator() {
        return this.mDisablePlatformApstreamGenerator;
    }

    public boolean getDontRenderApstream() {
        return this.mDontRenderApstream;
    }

    public boolean getDrawRedactAsRedacted() {
        return this.mDrawRedactAsRedacted;
    }

    public NativeFormRenderingConfig getFormRenderingConfig() {
        return this.mFormRenderingConfig;
    }

    public boolean getRenderGrayscale() {
        return this.mRenderGrayscale;
    }

    public boolean getRenderInvertedColors() {
        return this.mRenderInvertedColors;
    }

    public boolean getShouldApplyPageRotation() {
        return this.mShouldApplyPageRotation;
    }

    public boolean getShouldDrawFormHighlights() {
        return this.mShouldDrawFormHighlights;
    }

    public String toString() {
        return "NativeAnnotationRenderingConfig{mFormRenderingConfig=" + this.mFormRenderingConfig + ",mShouldDrawFormHighlights=" + this.mShouldDrawFormHighlights + ",mRenderGrayscale=" + this.mRenderGrayscale + ",mRenderInvertedColors=" + this.mRenderInvertedColors + ",mDontRenderApstream=" + this.mDontRenderApstream + ",mShouldApplyPageRotation=" + this.mShouldApplyPageRotation + ",mDisablePlatformApstreamGenerator=" + this.mDisablePlatformApstreamGenerator + ",mDrawRedactAsRedacted=" + this.mDrawRedactAsRedacted + "}";
    }
}

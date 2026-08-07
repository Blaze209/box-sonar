package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeProgressiveRenderConfig {
    final int mBitmapX;
    final int mBitmapY;
    final int mInitialRenderTimeMs;
    final int mPageHeight;
    final int mPageIndex;
    final int mPageWidth;

    public NativeProgressiveRenderConfig(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mPageIndex = i;
        this.mBitmapX = i2;
        this.mBitmapY = i3;
        this.mPageWidth = i4;
        this.mPageHeight = i5;
        this.mInitialRenderTimeMs = i6;
    }

    public int getBitmapX() {
        return this.mBitmapX;
    }

    public int getBitmapY() {
        return this.mBitmapY;
    }

    public int getInitialRenderTimeMs() {
        return this.mInitialRenderTimeMs;
    }

    public int getPageHeight() {
        return this.mPageHeight;
    }

    public int getPageIndex() {
        return this.mPageIndex;
    }

    public int getPageWidth() {
        return this.mPageWidth;
    }

    public String toString() {
        return "NativeProgressiveRenderConfig{mPageIndex=" + this.mPageIndex + ",mBitmapX=" + this.mBitmapX + ",mBitmapY=" + this.mBitmapY + ",mPageWidth=" + this.mPageWidth + ",mPageHeight=" + this.mPageHeight + ",mInitialRenderTimeMs=" + this.mInitialRenderTimeMs + "}";
    }
}

package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeXFDFOptions {
    final boolean mIgnorePageRotation;
    final boolean mRichTextEnabled;

    public NativeXFDFOptions(boolean z, boolean z2) {
        this.mIgnorePageRotation = z;
        this.mRichTextEnabled = z2;
    }

    public boolean getIgnorePageRotation() {
        return this.mIgnorePageRotation;
    }

    public boolean getRichTextEnabled() {
        return this.mRichTextEnabled;
    }

    public String toString() {
        return "NativeXFDFOptions{mIgnorePageRotation=" + this.mIgnorePageRotation + ",mRichTextEnabled=" + this.mRichTextEnabled + "}";
    }
}

package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeShapeDetectorResult {
    final int mMatchConfidence;
    final String mMatchingTemplateIdentifier;

    public NativeShapeDetectorResult(String str, int i) {
        this.mMatchingTemplateIdentifier = str;
        this.mMatchConfidence = i;
    }

    public int getMatchConfidence() {
        return this.mMatchConfidence;
    }

    public String getMatchingTemplateIdentifier() {
        return this.mMatchingTemplateIdentifier;
    }

    public String toString() {
        return "NativeShapeDetectorResult{mMatchingTemplateIdentifier=" + this.mMatchingTemplateIdentifier + ",mMatchConfidence=" + this.mMatchConfidence + "}";
    }
}

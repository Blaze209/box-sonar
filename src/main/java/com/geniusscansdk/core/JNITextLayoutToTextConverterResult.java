package com.geniusscansdk.core;

/* JADX INFO: loaded from: classes13.dex */
public final class JNITextLayoutToTextConverterResult {
    final int averageWordConfidence;
    final JNITextLayoutToTextConverterStatus status;
    final String text;
    final int wordCount;

    public JNITextLayoutToTextConverterResult(JNITextLayoutToTextConverterStatus jNITextLayoutToTextConverterStatus, String str, int i, int i2) {
        this.status = jNITextLayoutToTextConverterStatus;
        this.text = str;
        this.averageWordConfidence = i;
        this.wordCount = i2;
    }

    public JNITextLayoutToTextConverterStatus getStatus() {
        return this.status;
    }

    public String getText() {
        return this.text;
    }

    public int getAverageWordConfidence() {
        return this.averageWordConfidence;
    }

    public int getWordCount() {
        return this.wordCount;
    }

    public String toString() {
        return "JNITextLayoutToTextConverterResult{status=" + this.status + ",text=" + this.text + ",averageWordConfidence=" + this.averageWordConfidence + ",wordCount=" + this.wordCount + "}";
    }
}

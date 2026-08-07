package com.geniusscansdk.pdf;

import com.geniusscansdk.core.JNITextLayout;

/* JADX INFO: loaded from: classes13.dex */
final class JNIPDFPage {
    final String filePath;
    final JNIPDFImageData imageData;
    final JNIPDFSize inchesSize;
    final JNITextLayout textLayout;

    public JNIPDFPage(String str, JNIPDFImageData jNIPDFImageData, JNIPDFSize jNIPDFSize, JNITextLayout jNITextLayout) {
        this.filePath = str;
        this.imageData = jNIPDFImageData;
        this.inchesSize = jNIPDFSize;
        this.textLayout = jNITextLayout;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public JNIPDFImageData getImageData() {
        return this.imageData;
    }

    public JNIPDFSize getInchesSize() {
        return this.inchesSize;
    }

    public JNITextLayout getTextLayout() {
        return this.textLayout;
    }

    public String toString() {
        return "JNIPDFPage{filePath=" + this.filePath + ",imageData=" + this.imageData + ",inchesSize=" + this.inchesSize + ",textLayout=" + this.textLayout + "}";
    }
}

package com.geniusscansdk.pdf;

/* JADX INFO: loaded from: classes13.dex */
final class JNIPDFImageData {
    final byte[] buffer;
    final JNIPDFImageFormat format;

    public JNIPDFImageData(byte[] bArr, JNIPDFImageFormat jNIPDFImageFormat) {
        this.buffer = bArr;
        this.format = jNIPDFImageFormat;
    }

    public byte[] getBuffer() {
        return this.buffer;
    }

    public JNIPDFImageFormat getFormat() {
        return this.format;
    }

    public String toString() {
        return "JNIPDFImageData{buffer=" + this.buffer + ",format=" + this.format + "}";
    }
}

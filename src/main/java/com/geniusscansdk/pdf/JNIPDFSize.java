package com.geniusscansdk.pdf;

/* JADX INFO: loaded from: classes13.dex */
final class JNIPDFSize {
    final double height;
    final double width;

    public JNIPDFSize(double d, double d2) {
        this.width = d;
        this.height = d2;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public String toString() {
        return "JNIPDFSize{width=" + this.width + ",height=" + this.height + "}";
    }
}

package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeMeasurementContentFormat {
    final String mName;
    final NativeMeasurementPrecision mPrecision;
    final NativeMeasurementScale mScale;

    public NativeMeasurementContentFormat(String str, NativeMeasurementScale nativeMeasurementScale, NativeMeasurementPrecision nativeMeasurementPrecision) {
        this.mName = str;
        this.mScale = nativeMeasurementScale;
        this.mPrecision = nativeMeasurementPrecision;
    }

    public String getName() {
        return this.mName;
    }

    public NativeMeasurementPrecision getPrecision() {
        return this.mPrecision;
    }

    public NativeMeasurementScale getScale() {
        return this.mScale;
    }

    public String toString() {
        return "NativeMeasurementContentFormat{mName=" + this.mName + ",mScale=" + this.mScale + ",mPrecision=" + this.mPrecision + "}";
    }
}

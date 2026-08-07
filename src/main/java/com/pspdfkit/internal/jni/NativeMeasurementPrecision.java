package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeMeasurementPrecision {
    final int mPrecision;
    final NativeMeasurementPrecisionType mPrecisionType;

    public NativeMeasurementPrecision(int i, NativeMeasurementPrecisionType nativeMeasurementPrecisionType) {
        this.mPrecision = i;
        this.mPrecisionType = nativeMeasurementPrecisionType;
    }

    public int getPrecision() {
        return this.mPrecision;
    }

    public NativeMeasurementPrecisionType getPrecisionType() {
        return this.mPrecisionType;
    }

    public String toString() {
        return "NativeMeasurementPrecision{mPrecision=" + this.mPrecision + ",mPrecisionType=" + this.mPrecisionType + "}";
    }
}

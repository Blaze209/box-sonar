package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeMeasurementCalibration {
    final NativeUnitTo mUnitTo;
    final double mValue;

    public NativeMeasurementCalibration(double d, NativeUnitTo nativeUnitTo) {
        this.mValue = d;
        this.mUnitTo = nativeUnitTo;
    }

    public NativeUnitTo getUnitTo() {
        return this.mUnitTo;
    }

    public double getValue() {
        return this.mValue;
    }

    public String toString() {
        return "NativeMeasurementCalibration{mValue=" + this.mValue + ",mUnitTo=" + this.mUnitTo + "}";
    }
}

package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeMeasurementSecondaryUnit {
    final NativeMeasurementPrecision mPrecision;
    final NativeUnitTo mUnitTo;

    public NativeMeasurementSecondaryUnit(NativeUnitTo nativeUnitTo, NativeMeasurementPrecision nativeMeasurementPrecision) {
        this.mUnitTo = nativeUnitTo;
        this.mPrecision = nativeMeasurementPrecision;
    }

    public NativeMeasurementPrecision getPrecision() {
        return this.mPrecision;
    }

    public NativeUnitTo getUnitTo() {
        return this.mUnitTo;
    }

    public String toString() {
        return "NativeMeasurementSecondaryUnit{mUnitTo=" + this.mUnitTo + ",mPrecision=" + this.mPrecision + "}";
    }
}

package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeMeasurementScale {
    final double mFrom;
    final String mFromDescription;
    final double mTo;
    final String mToDescription;
    final NativeUnitFrom mUnitFrom;
    final NativeUnitTo mUnitTo;

    public NativeMeasurementScale(NativeUnitFrom nativeUnitFrom, NativeUnitTo nativeUnitTo, double d, double d2, String str, String str2) {
        this.mUnitFrom = nativeUnitFrom;
        this.mUnitTo = nativeUnitTo;
        this.mFrom = d;
        this.mTo = d2;
        this.mFromDescription = str;
        this.mToDescription = str2;
    }

    public double getFrom() {
        return this.mFrom;
    }

    public String getFromDescription() {
        return this.mFromDescription;
    }

    public double getTo() {
        return this.mTo;
    }

    public String getToDescription() {
        return this.mToDescription;
    }

    public NativeUnitFrom getUnitFrom() {
        return this.mUnitFrom;
    }

    public NativeUnitTo getUnitTo() {
        return this.mUnitTo;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeMeasurementScale{mUnitFrom=").append(this.mUnitFrom).append(",mUnitTo=").append(this.mUnitTo).append(",mFrom=").append(this.mFrom).append(",mTo=").append(this.mTo).append(",mFromDescription=").append(this.mFromDescription).append(",mToDescription="), this.mToDescription, "}");
    }
}

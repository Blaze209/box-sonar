package com.pspdfkit.internal;

import com.pspdfkit.annotations.measurements.MeasurementMode;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.annotations.measurements.ScaleAndPrecision;
import com.pspdfkit.annotations.measurements.SecondaryMeasurementUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class xp extends ScaleAndPrecision {
    public final Scale a;
    public final MeasurementPrecision b;
    public final MeasurementMode c;
    public final SecondaryMeasurementUnit d;

    public xp(Scale scale, MeasurementPrecision measurementPrecision, MeasurementMode measurementMode, SecondaryMeasurementUnit secondaryMeasurementUnit) {
        scale.getClass();
        measurementPrecision.getClass();
        measurementMode.getClass();
        this.a = scale;
        this.b = measurementPrecision;
        this.c = measurementMode;
        this.d = secondaryMeasurementUnit;
    }

    @Override // com.pspdfkit.annotations.measurements.ScaleAndPrecision
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xp)) {
            return false;
        }
        xp xpVar = (xp) obj;
        return Intrinsics.areEqual(this.a, xpVar.a) && this.b == xpVar.b && this.c == xpVar.c && Intrinsics.areEqual(this.d, xpVar.d);
    }

    @Override // com.pspdfkit.annotations.measurements.ScaleAndPrecision
    public final MeasurementPrecision getPrecision() {
        return this.b;
    }

    @Override // com.pspdfkit.annotations.measurements.ScaleAndPrecision
    public final Scale getScale() {
        return this.a;
    }

    @Override // com.pspdfkit.annotations.measurements.ScaleAndPrecision
    public final int hashCode() {
        int iHashCode = (this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31;
        SecondaryMeasurementUnit secondaryMeasurementUnit = this.d;
        return iHashCode + (secondaryMeasurementUnit == null ? 0 : secondaryMeasurementUnit.hashCode());
    }

    public final String toString() {
        return "MeasurementProperties(measurementScale=" + this.a + ", measurementPrecision=" + this.b + ", mode=" + this.c + ", secondaryUnit=" + this.d + ")";
    }
}

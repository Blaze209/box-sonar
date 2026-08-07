package com.pspdfkit.annotations.measurements;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class SecondaryMeasurementUnit {
    private final MeasurementPrecision precision;
    private final Scale.UnitTo unit;

    public SecondaryMeasurementUnit(MeasurementPrecision measurementPrecision, Scale.UnitTo unitTo) {
        this.precision = measurementPrecision;
        this.unit = unitTo;
    }

    public static SecondaryMeasurementUnit getDefault() {
        return new SecondaryMeasurementUnit(MeasurementPrecision.TWO_DP, Scale.UnitTo.IN);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SecondaryMeasurementUnit)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        SecondaryMeasurementUnit secondaryMeasurementUnit = (SecondaryMeasurementUnit) obj;
        return getUnit() == secondaryMeasurementUnit.getUnit() && getPrecision() == secondaryMeasurementUnit.getPrecision();
    }

    public MeasurementPrecision getPrecision() {
        return this.precision;
    }

    public Scale.UnitTo getUnit() {
        return this.unit;
    }

    public int hashCode() {
        return this.unit.hashCode() + ((this.precision.hashCode() + 527) * 31);
    }

    public String toString() {
        return "SecondaryMeasurementUnit{precision=" + this.precision + ", unit=" + this.unit + AbstractJsonLexerKt.END_OBJ;
    }
}

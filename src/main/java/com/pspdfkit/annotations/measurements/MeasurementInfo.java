package com.pspdfkit.annotations.measurements;

import com.box.android.observability.DiagnosisParams;
import com.pspdfkit.internal.uw;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class MeasurementInfo extends ScaleAndPrecision {
    public final String label;
    public final MeasurementMode measurementMode;
    public final MeasurementPrecision precision;
    public final Scale scale;
    public final float value;

    public MeasurementInfo(Scale scale, MeasurementPrecision measurementPrecision, MeasurementMode measurementMode, float f, String str) {
        uw.a(scale, "scale", null);
        uw.a(measurementPrecision, "precision", null);
        uw.a(measurementMode, DiagnosisParams.DIAGNOSIS_MODE, null);
        this.scale = scale;
        this.precision = measurementPrecision;
        this.measurementMode = measurementMode;
        this.value = f;
        this.label = str;
    }

    @Override // com.pspdfkit.annotations.measurements.ScaleAndPrecision
    public boolean equals(Object obj) {
        if (!super.equals(obj) || !(obj instanceof MeasurementInfo)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        MeasurementInfo measurementInfo = (MeasurementInfo) obj;
        if (Float.compare(measurementInfo.value, this.value) == 0 && this.measurementMode == measurementInfo.measurementMode) {
            return Objects.equals(this.label, measurementInfo.label);
        }
        return false;
    }

    @Override // com.pspdfkit.annotations.measurements.ScaleAndPrecision
    public MeasurementPrecision getPrecision() {
        return this.precision;
    }

    @Override // com.pspdfkit.annotations.measurements.ScaleAndPrecision
    public Scale getScale() {
        return this.scale;
    }

    @Override // com.pspdfkit.annotations.measurements.ScaleAndPrecision
    public int hashCode() {
        int iHashCode = (this.measurementMode.hashCode() + ((this.precision.hashCode() + ((this.scale.hashCode() + 527) * 31)) * 31)) * 31;
        String str = this.label;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        float f = this.value;
        return iHashCode2 + (f != 0.0f ? Float.floatToIntBits(f) : 0);
    }
}

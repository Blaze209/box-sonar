package com.pspdfkit.annotations;

import android.graphics.RectF;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.i10;
import com.pspdfkit.internal.j3;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.ww;
import com.pspdfkit.utils.Size;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ShapeAnnotation extends Annotation {
    public ShapeAnnotation(int i) {
        super(i);
    }

    public MeasurementPrecision getMeasurementPrecision() {
        return getInternal().getMeasurementPrecision();
    }

    public Scale getMeasurementScale() {
        return getInternal().getMeasurementScale();
    }

    @Override // com.pspdfkit.annotations.Annotation
    public Size getMinimumSize() {
        float fA = i10.a(this);
        Size minimumSize = super.getMinimumSize();
        float f = fA * 2.0f;
        return new Size(Math.max(minimumSize.width, f), Math.max(minimumSize.height, f));
    }

    @Override // com.pspdfkit.annotations.Annotation
    public boolean isMeasurement() {
        return this.propertyManager.h() != null;
    }

    public void setMeasurementPrecision(MeasurementPrecision measurementPrecision) {
        if (!ar.b().a(NativeLicenseFeatures.MEASUREMENT_TOOLS)) {
            throw new InvalidNutrientLicenseException("Your current license doesn't allow for measurement annotations.");
        }
        uw.a(measurementPrecision, "precision", null);
        getInternal().setMeasurementPrecision(measurementPrecision);
    }

    public void setMeasurementProperties(Scale scale, MeasurementPrecision measurementPrecision) {
        setMeasurementScale(scale);
        setMeasurementPrecision(measurementPrecision);
        float f = ww.a;
        setFontName(ar.c().b().getName());
        setTextSize(18.0f);
        setTextJustification(FreeTextAnnotation.FreeTextTextJustification.CENTER);
        setColor(ww.c);
        setBorderWidth(2.0f);
    }

    public void setMeasurementScale(Scale scale) {
        if (!ar.b().a(NativeLicenseFeatures.MEASUREMENT_TOOLS)) {
            throw new InvalidNutrientLicenseException("Your current license doesn't allow for measurement annotations.");
        }
        uw.a(scale, "scale", null);
        getInternal().setMeasurementScale(scale);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public void updateTransformationProperties(RectF rectF, RectF rectF2) {
        uw.a(rectF, "newBoundingBox", null);
        uw.a(rectF2, "oldBoundingBox", null);
    }

    public ShapeAnnotation(j3 j3Var, boolean z) {
        super(j3Var, z);
    }
}

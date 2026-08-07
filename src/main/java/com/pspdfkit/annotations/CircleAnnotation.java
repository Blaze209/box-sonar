package com.pspdfkit.annotations;

import android.graphics.RectF;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.internal.di;
import com.pspdfkit.internal.j3;
import com.pspdfkit.internal.jni.NativeMeasurementCalculator;
import com.pspdfkit.internal.mr;
import com.pspdfkit.internal.rp;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.xp;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes3.dex */
public class CircleAnnotation extends ShapeAnnotation {
    public CircleAnnotation(int i, RectF rectF) {
        super(i);
        uw.a(rectF, "rect", null);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(9, rectF, true);
        j3Var.l();
    }

    @Override // com.pspdfkit.annotations.Annotation
    public rp getMeasurementLabelValue(xp xpVar) {
        RectF boundingBox = getBoundingBox();
        float fWidth = boundingBox.width();
        float fHeight = boundingBox.height();
        xpVar.getClass();
        double measurementCircularArea = NativeMeasurementCalculator.getMeasurementCircularArea(Math.abs(fWidth), Math.abs(fHeight), mr.a(xpVar.a));
        DecimalFormat decimalFormat = di.a;
        float f = (float) measurementCircularArea;
        return new rp(di.a.a(xpVar, f), f);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public AnnotationType getType() {
        return AnnotationType.CIRCLE;
    }

    @Override // com.pspdfkit.annotations.Annotation
    public CircleAnnotation getCopy() {
        CircleAnnotation circleAnnotation = new CircleAnnotation(this.propertyManager, true);
        circleAnnotation.getInternal().prepareForCopy();
        return circleAnnotation;
    }

    public CircleAnnotation(int i, RectF rectF, Scale scale, MeasurementPrecision measurementPrecision) {
        this(i, rectF);
        setMeasurementProperties(scale, measurementPrecision);
    }

    public CircleAnnotation(j3 j3Var, boolean z) {
        super(j3Var, z);
    }
}

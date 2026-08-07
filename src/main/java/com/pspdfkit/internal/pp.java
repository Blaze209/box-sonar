package com.pspdfkit.internal;

import android.graphics.PointF;
import android.util.TypedValue;
import androidx.appcompat.R;
import com.pspdfkit.annotations.LineAnnotation;
import com.pspdfkit.annotations.measurements.MeasurementMode;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;

/* JADX INFO: loaded from: classes3.dex */
public final class pp extends o7<xn> {
    public final AnnotationTool G;
    public final boolean H;

    public static final class a extends xn {
        public a(zn znVar) {
            super(znVar);
        }

        @Override // com.pspdfkit.internal.xn
        public final LineAnnotation a(int i, PointF pointF, PointF pointF2) {
            LineAnnotation lineAnnotationCreateCalibrationLineAnnotation = LineAnnotation.createCalibrationLineAnnotation(i, pointF, pointF2);
            lineAnnotationCreateCalibrationLineAnnotation.getClass();
            return lineAnnotationCreateCalibrationLineAnnotation;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pp(q0 q0Var, AnnotationToolVariant annotationToolVariant, AnnotationTool annotationTool) {
        super(q0Var, annotationToolVariant);
        q0Var.getClass();
        annotationToolVariant.getClass();
        annotationTool.getClass();
        this.G = annotationTool;
        this.H = annotationTool == AnnotationTool.MEASUREMENT_SCALE_CALIBRATION;
    }

    @Override // com.pspdfkit.internal.o7
    public final void a(PointF pointF, PointF pointF2) {
        this.u.b(pointF, pointF2);
    }

    @Override // com.pspdfkit.internal.gu
    public final int f() {
        return 15;
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationTool h() {
        return this.G;
    }

    @Override // com.pspdfkit.internal.o7
    public final boolean m() {
        return this.H;
    }

    @Override // com.pspdfkit.internal.o7
    public final r4 n() {
        q0.a aVar = this.a.p;
        zn znVar = new zn(aVar.b, aVar.c, aVar.e, aVar.i, aVar.g, aVar.h);
        if (!this.H) {
            MeasurementValueConfiguration measurementValueConfiguration = this.a.getMeasurementValueConfiguration();
            Scale scale = measurementValueConfiguration.getScale();
            MeasurementPrecision precision = measurementValueConfiguration.getPrecision();
            MeasurementMode measurementMode = MeasurementMode.DISTANCE;
            PdfDocument document = this.a.f.getDocument();
            znVar.a(new xp(scale, precision, measurementMode, document != null ? ((lm) document).getSecondaryMeasurementUnit() : null));
            return new xn(znVar);
        }
        TypedValue typedValue = new TypedValue();
        this.a.a.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        znVar.e = typedValue.data;
        MeasurementValueConfiguration measurementValueConfigurationDefaultConfiguration = MeasurementValueConfiguration.INSTANCE.defaultConfiguration();
        Scale scale2 = measurementValueConfigurationDefaultConfiguration.getScale();
        MeasurementPrecision precision2 = measurementValueConfigurationDefaultConfiguration.getPrecision();
        MeasurementMode measurementMode2 = MeasurementMode.DISTANCE;
        PdfDocument document2 = this.a.f.getDocument();
        znVar.a(new xp(scale2, precision2, measurementMode2, document2 != null ? ((lm) document2).getSecondaryMeasurementUnit() : null));
        return new a(znVar);
    }

    @Override // com.pspdfkit.internal.o7
    public final boolean u() {
        return this.H;
    }
}

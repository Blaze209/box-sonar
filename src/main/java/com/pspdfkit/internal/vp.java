package com.pspdfkit.internal;

import com.pspdfkit.annotations.measurements.MeasurementMode;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;

/* JADX INFO: loaded from: classes3.dex */
public final class vp extends l7<pw> {
    public final AnnotationTool J;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vp(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var, annotationToolVariant);
        q0Var.getClass();
        annotationToolVariant.getClass();
        this.J = AnnotationTool.MEASUREMENT_PERIMETER;
    }

    @Override // com.pspdfkit.internal.l7, com.pspdfkit.internal.o7
    public final boolean b(float f, float f2) {
        T t = this.l;
        if (t != 0) {
            k7 k7Var = (k7) ((j7) t).a;
            k7Var.u = false;
            k7Var.v = true;
            k7Var.a(2);
            if (true != k7Var.l) {
                k7Var.h();
                k7Var.l = true;
            }
            r();
            this.l = null;
        }
        return true;
    }

    @Override // com.pspdfkit.internal.gu
    public final int f() {
        return 19;
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationTool h() {
        return this.J;
    }

    @Override // com.pspdfkit.internal.l7
    public final j7 y() {
        q0.a aVar = this.a.p;
        qw qwVar = new qw(aVar.b, aVar.c, aVar.e, aVar.i, aVar.g, aVar.h);
        MeasurementValueConfiguration measurementValueConfiguration = this.a.getMeasurementValueConfiguration();
        Scale scale = measurementValueConfiguration.getScale();
        MeasurementPrecision precision = measurementValueConfiguration.getPrecision();
        MeasurementMode measurementMode = MeasurementMode.PERIMETER;
        PdfDocument document = this.a.f.getDocument();
        qwVar.a(new xp(scale, precision, measurementMode, document != null ? ((lm) document).getSecondaryMeasurementUnit() : null));
        return new pw(qwVar);
    }
}

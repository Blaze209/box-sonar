package com.pspdfkit.internal;

import com.pspdfkit.annotations.measurements.MeasurementMode;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;

/* JADX INFO: loaded from: classes3.dex */
public final class mp extends s70<t20> {
    public final int G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mp(q0 q0Var, AnnotationToolVariant annotationToolVariant, int i) {
        super(q0Var, annotationToolVariant);
        q0Var.getClass();
        annotationToolVariant.getClass();
        if (i == 0) {
            throw null;
        }
        this.G = i;
    }

    @Override // com.pspdfkit.internal.gu
    public final int f() {
        return this.G == 2 ? 17 : 16;
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationTool h() {
        return this.G == 2 ? AnnotationTool.MEASUREMENT_AREA_ELLIPSE : AnnotationTool.MEASUREMENT_AREA_RECT;
    }

    @Override // com.pspdfkit.internal.o7
    public final r4 n() {
        q0.a aVar = this.a.p;
        a30 a30Var = new a30(aVar.b, aVar.c, aVar.e, aVar.i, aVar.g, this.G);
        MeasurementValueConfiguration measurementValueConfiguration = this.a.getMeasurementValueConfiguration();
        Scale scale = measurementValueConfiguration.getScale();
        MeasurementPrecision precision = measurementValueConfiguration.getPrecision();
        MeasurementMode measurementMode = MeasurementMode.AREA;
        PdfDocument document = this.a.f.getDocument();
        a30Var.a(new xp(scale, precision, measurementMode, document != null ? ((lm) document).getSecondaryMeasurementUnit() : null));
        return new t20(a30Var);
    }

    @Override // com.pspdfkit.internal.o7
    public final boolean v() {
        if (this.G == 2) {
            return false;
        }
        return super.v();
    }
}

package com.pspdfkit.internal;

import com.pspdfkit.annotations.measurements.MeasurementMode;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;

/* JADX INFO: loaded from: classes3.dex */
public final class lp extends l7<mw> {
    public final AnnotationTool J;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lp(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var, annotationToolVariant);
        q0Var.getClass();
        annotationToolVariant.getClass();
        this.J = AnnotationTool.MEASUREMENT_AREA_POLYGON;
    }

    @Override // com.pspdfkit.internal.gu
    public final int f() {
        return 18;
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationTool h() {
        return this.J;
    }

    @Override // com.pspdfkit.internal.o7
    public final void o() {
        super.o();
        T t = this.l;
        if (t != 0) {
            mw mwVar = (mw) t;
            int iC = mwVar.a.c();
            if (iC == 0) {
                throw null;
            }
            boolean z = iC != 1;
            DrawingShape drawingshape = mwVar.a;
            if (z != drawingshape.l) {
                drawingshape.h();
                drawingshape.l = z;
            }
        }
    }

    @Override // com.pspdfkit.internal.l7
    public final j7 y() {
        q0.a aVar = this.a.p;
        nw nwVar = new nw(aVar.b, aVar.c, aVar.e, aVar.i, aVar.g);
        MeasurementValueConfiguration measurementValueConfiguration = this.a.getMeasurementValueConfiguration();
        Scale scale = measurementValueConfiguration.getScale();
        MeasurementPrecision precision = measurementValueConfiguration.getPrecision();
        MeasurementMode measurementMode = MeasurementMode.AREA;
        PdfDocument document = this.a.f.getDocument();
        nwVar.a(new xp(scale, precision, measurementMode, document != null ? ((lm) document).getSecondaryMeasurementUnit() : null));
        return new mw(nwVar);
    }
}

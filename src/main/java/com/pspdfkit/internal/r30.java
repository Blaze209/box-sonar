package com.pspdfkit.internal;

import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;

/* JADX INFO: loaded from: classes3.dex */
public final class r30 extends s70<t20> {
    public r30(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var, annotationToolVariant);
        PdfConfiguration pdfConfiguration = q0Var.z;
        if (pdfConfiguration.getSelectedAnnotationResizeGuidesEnabled()) {
            this.t = new ef(pdfConfiguration);
        }
    }

    @Override // com.pspdfkit.internal.gu
    public final int f() {
        return 16;
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationTool h() {
        return AnnotationTool.SQUARE;
    }

    @Override // com.pspdfkit.internal.o7
    public final r4 n() {
        q0.a aVar = this.a.p;
        return new t20(aVar.b, aVar.c, aVar.e, aVar.i, x(), 1);
    }
}

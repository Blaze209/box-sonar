package com.pspdfkit.internal;

import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;

/* JADX INFO: loaded from: classes3.dex */
public final class lw extends l7<mw> {
    public lw(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var, annotationToolVariant);
    }

    @Override // com.pspdfkit.internal.gu
    public final int f() {
        return 18;
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationTool h() {
        return AnnotationTool.POLYGON;
    }

    @Override // com.pspdfkit.internal.l7
    public final j7 y() {
        q0.a aVar = this.a.p;
        return new mw(aVar.b, aVar.c, aVar.e, aVar.i, x());
    }
}

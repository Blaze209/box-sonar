package com.pspdfkit.internal;

import android.graphics.PointF;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;

/* JADX INFO: loaded from: classes3.dex */
public final class wn extends o7<xn> {
    public wn(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var, annotationToolVariant);
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
        return AnnotationTool.LINE;
    }

    @Override // com.pspdfkit.internal.o7
    public final r4 n() {
        q0.a aVar = this.a.p;
        return new xn(aVar.b, aVar.c, aVar.e, aVar.i, aVar.g, aVar.h);
    }
}

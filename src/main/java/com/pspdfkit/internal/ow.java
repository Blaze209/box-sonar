package com.pspdfkit.internal;

import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;

/* JADX INFO: loaded from: classes3.dex */
public final class ow extends l7<pw> {
    public ow(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var, annotationToolVariant);
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
        return AnnotationTool.POLYLINE;
    }

    @Override // com.pspdfkit.internal.l7
    public final j7 y() {
        q0.a aVar = this.a.p;
        return new pw(aVar.b, aVar.c, aVar.e, aVar.i, aVar.g, aVar.h);
    }
}

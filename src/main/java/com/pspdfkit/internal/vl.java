package com.pspdfkit.internal;

import com.pspdfkit.annotations.BaseRectsAnnotation;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class vl extends qj {
    public final AnnotationTool s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vl(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var, annotationToolVariant);
        q0Var.getClass();
        annotationToolVariant.getClass();
        this.s = AnnotationTool.INSTANT_HIGHLIGHT_COMMENT;
    }

    @Override // com.pspdfkit.internal.s50, com.pspdfkit.internal.dp
    public final BaseRectsAnnotation a(ArrayList arrayList) {
        BaseRectsAnnotation baseRectsAnnotationA = super.a(arrayList);
        if (baseRectsAnnotationA == null) {
            return null;
        }
        baseRectsAnnotationA.getInternal().markAsInstantCommentRoot();
        return baseRectsAnnotationA;
    }

    @Override // com.pspdfkit.internal.s50, com.pspdfkit.internal.d3
    public final AnnotationTool h() {
        return this.s;
    }

    @Override // com.pspdfkit.internal.dp
    public final void a(BaseRectsAnnotation baseRectsAnnotation, q0 q0Var) {
        q0Var.getClass();
        q0Var.d.a(baseRectsAnnotation);
    }
}

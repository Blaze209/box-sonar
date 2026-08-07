package com.pspdfkit.internal;

import com.pspdfkit.annotations.BaseRectsAnnotation;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s50 extends dp {
    public final int p;
    public final Function1<Integer, BaseRectsAnnotation> q;
    public final AnnotationTool r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (Lcom/pspdfkit/internal/q0;Lcom/pspdfkit/ui/special_mode/controller/AnnotationToolVariant;Lcom/pspdfkit/ui/special_mode/controller/AnnotationTool;Ljava/lang/Object;Lkotlin/jvm/functions/Function1<-Ljava/lang/Integer;+Lcom/pspdfkit/annotations/BaseRectsAnnotation;>;)V */
    public s50(q0 q0Var, AnnotationToolVariant annotationToolVariant, AnnotationTool annotationTool, int i, Function1 function1) {
        super(q0Var, annotationToolVariant);
        q0Var.getClass();
        annotationToolVariant.getClass();
        annotationTool.getClass();
        if (i == 0) {
            throw null;
        }
        function1.getClass();
        this.p = i;
        this.q = function1;
        this.r = annotationTool;
    }

    @Override // com.pspdfkit.internal.dp
    public BaseRectsAnnotation a(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return null;
        }
        return this.q.invoke(Integer.valueOf(k()));
    }

    @Override // com.pspdfkit.internal.gu
    public final int f() {
        return this.p;
    }

    @Override // com.pspdfkit.internal.d3
    public AnnotationTool h() {
        return this.r;
    }
}

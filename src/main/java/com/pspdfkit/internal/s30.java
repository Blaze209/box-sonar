package com.pspdfkit.internal;

import android.graphics.RectF;
import com.pspdfkit.annotations.BaseRectsAnnotation;
import com.pspdfkit.annotations.SquigglyAnnotation;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class s30 extends s50 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s30(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var, annotationToolVariant, AnnotationTool.SQUIGGLY, 8, new Function1() { // from class: com.pspdfkit.internal.s30$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return s30.a(((Integer) obj).intValue());
            }
        });
        q0Var.getClass();
        annotationToolVariant.getClass();
    }

    public static final BaseRectsAnnotation a(int i) {
        return new SquigglyAnnotation(i, (List<RectF>) CollectionsKt.emptyList());
    }
}

package com.pspdfkit.internal;

import android.graphics.RectF;
import com.pspdfkit.annotations.BaseRectsAnnotation;
import com.pspdfkit.annotations.HighlightAnnotation;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public class qj extends s50 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qj(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var, annotationToolVariant, AnnotationTool.HIGHLIGHT, 7, new Function1() { // from class: com.pspdfkit.internal.qj$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return qj.a(((Integer) obj).intValue());
            }
        });
        q0Var.getClass();
        annotationToolVariant.getClass();
    }

    public static final BaseRectsAnnotation a(int i) {
        return new HighlightAnnotation(i, (List<RectF>) CollectionsKt.emptyList());
    }
}

package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.annotations.configuration.AnnotationProperty;
import com.pspdfkit.annotations.configuration.MeasurementPerimeterAnnotationConfiguration;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;

/* JADX INFO: loaded from: classes3.dex */
public final class tp extends h1<MeasurementPerimeterAnnotationConfiguration.Builder> implements MeasurementPerimeterAnnotationConfiguration.Builder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tp(Context context) {
        super(context, AnnotationTool.LINE, AnnotationProperty.COLOR, AnnotationProperty.THICKNESS, AnnotationProperty.ANNOTATION_ALPHA, AnnotationProperty.SCALE, AnnotationProperty.MEASUREMENT_PRECISION, AnnotationProperty.BORDER_STYLE, AnnotationProperty.LINE_ENDS, AnnotationProperty.LINE_ENDS_FILL_COLOR);
        context.getClass();
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final MeasurementPerimeterAnnotationConfiguration build() {
        j1 j1Var = this.a;
        i1<Float> i1Var = i1.m;
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj == null) {
            obj = null;
        }
        if (((Float) obj) == null) {
            j1 j1Var2 = this.a;
            Float fValueOf = Float.valueOf(20.0f);
            j1Var2.getClass();
            j1Var2.a.put(i1Var, fValueOf);
        }
        a();
        return new up(this.a);
    }
}

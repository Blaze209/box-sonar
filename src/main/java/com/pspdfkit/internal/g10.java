package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.annotations.configuration.AnnotationConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationProperty;
import com.pspdfkit.annotations.configuration.ShapeAnnotationConfiguration;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;

/* JADX INFO: loaded from: classes3.dex */
public final class g10 extends h1<ShapeAnnotationConfiguration.Builder> implements ShapeAnnotationConfiguration.Builder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g10(Context context, AnnotationTool annotationTool) {
        super(context, annotationTool, AnnotationProperty.COLOR, AnnotationProperty.THICKNESS, AnnotationProperty.BORDER_STYLE, AnnotationProperty.FILL_COLOR, AnnotationProperty.ANNOTATION_NOTE, AnnotationProperty.ANNOTATION_ALPHA);
        context.getClass();
        annotationTool.getClass();
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final AnnotationConfiguration build() {
        a();
        return new h10(this.a);
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final ShapeAnnotationConfiguration build() {
        a();
        return new h10(this.a);
    }
}

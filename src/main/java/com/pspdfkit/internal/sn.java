package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.annotations.configuration.AnnotationConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationProperty;
import com.pspdfkit.annotations.configuration.LineAnnotationConfiguration;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;

/* JADX INFO: loaded from: classes3.dex */
public final class sn extends h1<LineAnnotationConfiguration.Builder> implements LineAnnotationConfiguration.Builder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sn(Context context, AnnotationTool annotationTool) {
        super(context, annotationTool, AnnotationProperty.COLOR, AnnotationProperty.THICKNESS, AnnotationProperty.BORDER_STYLE, AnnotationProperty.LINE_ENDS, AnnotationProperty.LINE_ENDS_FILL_COLOR, AnnotationProperty.ANNOTATION_NOTE, AnnotationProperty.ANNOTATION_ALPHA);
        context.getClass();
        annotationTool.getClass();
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final AnnotationConfiguration build() {
        a();
        return new tn(this.a);
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final LineAnnotationConfiguration build() {
        a();
        return new tn(this.a);
    }
}

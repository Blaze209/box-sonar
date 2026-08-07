package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.annotations.configuration.AnnotationConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationProperty;
import com.pspdfkit.annotations.configuration.MarkupAnnotationConfiguration;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;

/* JADX INFO: loaded from: classes3.dex */
public final class bp extends h1<MarkupAnnotationConfiguration.Builder> implements MarkupAnnotationConfiguration.Builder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bp(Context context, AnnotationTool annotationTool) {
        super(context, annotationTool, AnnotationProperty.COLOR, AnnotationProperty.ANNOTATION_NOTE, AnnotationProperty.ANNOTATION_ALPHA);
        context.getClass();
        annotationTool.getClass();
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final AnnotationConfiguration build() {
        a();
        return new cp(this.a);
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final MarkupAnnotationConfiguration build() {
        a();
        return new cp(this.a);
    }
}

package com.pspdfkit.annotations.configuration;

import android.content.Context;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.internal.bp;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;

/* JADX INFO: loaded from: classes3.dex */
public interface MarkupAnnotationConfiguration extends AnnotationColorConfiguration, AnnotationAlphaConfiguration {

    public interface Builder extends AnnotationColorConfiguration.Builder<Builder>, AnnotationAlphaConfiguration.Builder<Builder> {
        @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
        MarkupAnnotationConfiguration build();
    }

    static Builder builder(Context context, AnnotationType annotationType) {
        return builder(context, AnnotationTool.fromAnnotationType(annotationType));
    }

    static Builder builder(Context context, AnnotationTool annotationTool) {
        return new bp(context, annotationTool);
    }
}

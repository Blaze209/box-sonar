package com.pspdfkit.annotations.configuration;

import android.content.Context;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.internal.g10;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;

/* JADX INFO: loaded from: classes3.dex */
public interface ShapeAnnotationConfiguration extends AnnotationColorConfiguration, AnnotationThicknessConfiguration, AnnotationPreviewConfiguration, AnnotationAlphaConfiguration, AnnotationBorderStyleConfiguration, AnnotationFillColorConfiguration {

    public interface Builder extends AnnotationColorConfiguration.Builder<Builder>, AnnotationThicknessConfiguration.Builder<Builder>, AnnotationBorderStyleConfiguration.Builder<Builder>, AnnotationFillColorConfiguration.Builder<Builder>, AnnotationAlphaConfiguration.Builder<Builder>, AnnotationPreviewConfiguration.Builder<Builder> {
        @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
        ShapeAnnotationConfiguration build();
    }

    static Builder builder(Context context, AnnotationType annotationType) {
        return builder(context, AnnotationTool.fromAnnotationType(annotationType));
    }

    static Builder builder(Context context, AnnotationTool annotationTool) {
        return new g10(context, annotationTool);
    }
}

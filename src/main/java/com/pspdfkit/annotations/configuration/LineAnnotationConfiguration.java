package com.pspdfkit.annotations.configuration;

import android.content.Context;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.internal.sn;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;

/* JADX INFO: loaded from: classes3.dex */
public interface LineAnnotationConfiguration extends AnnotationColorConfiguration, AnnotationThicknessConfiguration, AnnotationPreviewConfiguration, AnnotationAlphaConfiguration, AnnotationBorderStyleConfiguration, AnnotationFillColorConfiguration, AnnotationLineEndsConfiguration {

    public interface Builder extends AnnotationColorConfiguration.Builder<Builder>, AnnotationThicknessConfiguration.Builder<Builder>, AnnotationPreviewConfiguration.Builder<Builder>, AnnotationAlphaConfiguration.Builder<Builder>, AnnotationBorderStyleConfiguration.Builder<Builder>, AnnotationFillColorConfiguration.Builder<Builder>, AnnotationLineEndsConfiguration.Builder<Builder> {
        @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
        LineAnnotationConfiguration build();
    }

    static Builder builder(Context context) {
        return builder(context, AnnotationTool.LINE);
    }

    static Builder builder(Context context, AnnotationType annotationType) {
        return builder(context, AnnotationTool.fromAnnotationType(annotationType));
    }

    static Builder builder(Context context, AnnotationTool annotationTool) {
        return new sn(context, annotationTool);
    }
}

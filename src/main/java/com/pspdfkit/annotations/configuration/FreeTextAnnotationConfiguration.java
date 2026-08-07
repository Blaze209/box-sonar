package com.pspdfkit.annotations.configuration;

import android.content.Context;
import com.pspdfkit.internal.hi;

/* JADX INFO: loaded from: classes3.dex */
public interface FreeTextAnnotationConfiguration extends AnnotationColorConfiguration, AnnotationFillColorConfiguration, AnnotationPreviewConfiguration, AnnotationAlphaConfiguration, AnnotationThicknessConfiguration, AnnotationTextSizeConfiguration, AnnotationBorderStyleConfiguration, AnnotationLineEndsConfiguration, AnnotationFontConfiguration, AnnotationTextResizingConfiguration {

    public interface Builder extends AnnotationColorConfiguration.Builder<Builder>, AnnotationFillColorConfiguration.Builder<Builder>, AnnotationPreviewConfiguration.Builder<Builder>, AnnotationAlphaConfiguration.Builder<Builder>, AnnotationThicknessConfiguration.Builder<Builder>, AnnotationTextSizeConfiguration.Builder<Builder>, AnnotationBorderStyleConfiguration.Builder<Builder>, AnnotationLineEndsConfiguration.Builder<Builder>, AnnotationFontConfiguration.Builder<Builder>, AnnotationTextResizingConfiguration.Builder<Builder> {
        @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
        FreeTextAnnotationConfiguration build();
    }

    static Builder builder(Context context) {
        return new hi(context);
    }
}

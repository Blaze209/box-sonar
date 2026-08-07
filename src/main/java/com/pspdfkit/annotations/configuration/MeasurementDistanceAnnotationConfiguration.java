package com.pspdfkit.annotations.configuration;

import android.content.Context;
import com.pspdfkit.internal.np;

/* JADX INFO: loaded from: classes3.dex */
public interface MeasurementDistanceAnnotationConfiguration extends AnnotationColorConfiguration, AnnotationThicknessConfiguration, AnnotationPreviewConfiguration, AnnotationAlphaConfiguration, AnnotationLineEndsConfiguration, AnnotationScaleConfiguration, AnnotationPrecisionConfiguration, AnnotationBorderStyleConfiguration, AnnotationFillColorConfiguration {

    public interface Builder extends AnnotationColorConfiguration.Builder<Builder>, AnnotationThicknessConfiguration.Builder<Builder>, AnnotationPreviewConfiguration.Builder<Builder>, AnnotationAlphaConfiguration.Builder<Builder>, AnnotationLineEndsConfiguration.Builder<Builder>, AnnotationScaleConfiguration.Builder<Builder>, AnnotationPrecisionConfiguration.Builder<Builder>, AnnotationBorderStyleConfiguration.Builder<Builder>, AnnotationFillColorConfiguration.Builder<Builder> {
        @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
        MeasurementDistanceAnnotationConfiguration build();
    }

    static Builder builder(Context context) {
        return new np(context);
    }
}

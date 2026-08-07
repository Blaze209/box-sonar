package com.pspdfkit.annotations.configuration;

import android.content.Context;
import com.pspdfkit.internal.tp;

/* JADX INFO: loaded from: classes3.dex */
public interface MeasurementPerimeterAnnotationConfiguration extends AnnotationColorConfiguration, AnnotationThicknessConfiguration, AnnotationPreviewConfiguration, AnnotationAlphaConfiguration, AnnotationLineEndsConfiguration, AnnotationScaleConfiguration, AnnotationPrecisionConfiguration, AnnotationBorderStyleConfiguration, AnnotationFillColorConfiguration {

    public interface Builder extends AnnotationColorConfiguration.Builder<Builder>, AnnotationThicknessConfiguration.Builder<Builder>, AnnotationPreviewConfiguration.Builder<Builder>, AnnotationAlphaConfiguration.Builder<Builder>, AnnotationLineEndsConfiguration.Builder<Builder>, AnnotationScaleConfiguration.Builder<Builder>, AnnotationPrecisionConfiguration.Builder<Builder>, AnnotationBorderStyleConfiguration.Builder<Builder>, AnnotationFillColorConfiguration.Builder<Builder> {
        @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
        MeasurementPerimeterAnnotationConfiguration build();
    }

    static Builder builder(Context context) {
        return new tp(context);
    }
}

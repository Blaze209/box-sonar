package com.pspdfkit.annotations.configuration;

import android.content.Context;
import com.pspdfkit.internal.hk;

/* JADX INFO: loaded from: classes3.dex */
public interface InkAnnotationConfiguration extends AnnotationAlphaConfiguration, AnnotationThicknessConfiguration, AnnotationColorConfiguration, AnnotationFillColorConfiguration, AnnotationPreviewConfiguration, AnnotationAggregationStrategyConfiguration {

    public interface Builder extends AnnotationAlphaConfiguration.Builder<Builder>, AnnotationThicknessConfiguration.Builder<Builder>, AnnotationColorConfiguration.Builder<Builder>, AnnotationFillColorConfiguration.Builder<Builder>, AnnotationPreviewConfiguration.Builder<Builder>, AnnotationAggregationStrategyConfiguration.Builder<Builder> {
        @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
        InkAnnotationConfiguration build();
    }

    static Builder builder(Context context) {
        return new hk(context);
    }
}

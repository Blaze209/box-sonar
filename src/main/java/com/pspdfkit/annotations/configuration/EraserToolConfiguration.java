package com.pspdfkit.annotations.configuration;

import com.pspdfkit.internal.mg;

/* JADX INFO: loaded from: classes3.dex */
public interface EraserToolConfiguration extends AnnotationThicknessConfiguration, AnnotationPreviewConfiguration {

    public interface Builder extends AnnotationThicknessConfiguration.Builder<Builder>, AnnotationPreviewConfiguration.Builder<Builder> {
        @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
        EraserToolConfiguration build();
    }

    static Builder builder() {
        return new mg();
    }
}

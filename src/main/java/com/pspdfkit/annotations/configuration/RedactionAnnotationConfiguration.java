package com.pspdfkit.annotations.configuration;

import android.content.Context;
import com.pspdfkit.internal.ux;

/* JADX INFO: loaded from: classes3.dex */
public interface RedactionAnnotationConfiguration extends AnnotationColorConfiguration, AnnotationFillColorConfiguration, AnnotationPreviewConfiguration, AnnotationOutlineColorConfiguration, AnnotationOverlayTextConfiguration {

    public interface Builder extends AnnotationColorConfiguration.Builder<Builder>, AnnotationFillColorConfiguration.Builder<Builder>, AnnotationPreviewConfiguration.Builder<Builder>, AnnotationOutlineColorConfiguration.Builder<Builder>, AnnotationOverlayTextConfiguration.Builder<Builder> {
        @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
        RedactionAnnotationConfiguration build();
    }

    static Builder builder(Context context) {
        return new ux(context);
    }
}

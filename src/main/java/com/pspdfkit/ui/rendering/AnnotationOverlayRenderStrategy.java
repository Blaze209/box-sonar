package com.pspdfkit.ui.rendering;

import com.pspdfkit.annotations.Annotation;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationOverlayRenderStrategy {

    public enum Strategy {
        AP_STREAM_RENDERING,
        PLATFORM_RENDERING
    }

    Strategy getOverlayRenderStrategy(Annotation annotation);
}

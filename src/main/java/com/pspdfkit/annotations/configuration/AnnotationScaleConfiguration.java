package com.pspdfkit.annotations.configuration;

import com.pspdfkit.annotations.measurements.Scale;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationScaleConfiguration extends AnnotationConfiguration {

    public interface Builder<T> extends AnnotationConfiguration.Builder<T> {
        T setDefaultScale(Scale scale);
    }

    Scale getDefaultScale();
}

package com.pspdfkit.annotations.configuration;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationThicknessConfiguration extends AnnotationConfiguration {

    public interface Builder<T> extends AnnotationConfiguration.Builder<T> {
        T setDefaultThickness(float f);

        T setMaxThickness(float f);

        T setMinThickness(float f);
    }

    float getDefaultThickness();

    float getMaxThickness();

    float getMinThickness();
}

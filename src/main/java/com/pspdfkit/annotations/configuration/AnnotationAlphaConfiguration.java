package com.pspdfkit.annotations.configuration;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationAlphaConfiguration extends AnnotationConfiguration {

    public interface Builder<T> extends AnnotationConfiguration.Builder<T> {
        T setDefaultAlpha(float f);

        T setMaxAlpha(float f);

        T setMinAlpha(float f);
    }

    float getDefaultAlpha();

    float getMaxAlpha();

    float getMinAlpha();
}

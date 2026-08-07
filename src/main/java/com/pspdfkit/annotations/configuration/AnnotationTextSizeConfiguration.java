package com.pspdfkit.annotations.configuration;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationTextSizeConfiguration extends AnnotationConfiguration {

    public interface Builder<T> extends AnnotationConfiguration.Builder<T> {
        T setDefaultTextSize(float f);

        T setMaxTextSize(float f);

        T setMinTextSize(float f);
    }

    float getDefaultTextSize();

    float getMaxTextSize();

    float getMinTextSize();
}

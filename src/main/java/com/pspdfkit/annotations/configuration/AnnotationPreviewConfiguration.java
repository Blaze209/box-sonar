package com.pspdfkit.annotations.configuration;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationPreviewConfiguration extends AnnotationConfiguration {

    public interface Builder<T> extends AnnotationConfiguration.Builder<T> {
        T setPreviewEnabled(boolean z);
    }

    boolean isPreviewEnabled();
}

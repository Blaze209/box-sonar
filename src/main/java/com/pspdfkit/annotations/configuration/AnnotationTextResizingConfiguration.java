package com.pspdfkit.annotations.configuration;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationTextResizingConfiguration extends AnnotationConfiguration {

    public interface Builder<T> extends AnnotationConfiguration.Builder<T> {
        T setHorizontalResizingEnabled(boolean z);

        T setVerticalResizingEnabled(boolean z);
    }

    boolean isHorizontalResizingEnabled();

    boolean isVerticalResizingEnabled();
}

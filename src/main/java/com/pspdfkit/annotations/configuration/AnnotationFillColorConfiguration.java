package com.pspdfkit.annotations.configuration;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationFillColorConfiguration extends AnnotationConfiguration {

    public interface Builder<T> extends AnnotationConfiguration.Builder<T> {
        T setAvailableFillColors(List<Integer> list);

        T setCustomColorPickerEnabled(boolean z);

        T setDefaultFillColor(int i);
    }

    boolean customColorPickerEnabled();

    List<Integer> getAvailableFillColors();

    int getDefaultFillColor();
}

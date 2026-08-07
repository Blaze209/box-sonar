package com.pspdfkit.annotations.configuration;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationColorConfiguration extends AnnotationConfiguration {

    public interface Builder<T> extends AnnotationConfiguration.Builder<T> {
        T setAvailableColors(List<Integer> list);

        T setCustomColorPickerEnabled(boolean z);

        T setDefaultColor(int i);
    }

    boolean customColorPickerEnabled();

    List<Integer> getAvailableColors();

    int getDefaultColor();
}

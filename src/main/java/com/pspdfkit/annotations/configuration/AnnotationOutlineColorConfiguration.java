package com.pspdfkit.annotations.configuration;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationOutlineColorConfiguration extends AnnotationConfiguration {

    public interface Builder<T extends AnnotationConfiguration.Builder> extends AnnotationConfiguration.Builder<T> {
        T setAvailableOutlineColors(List<Integer> list);

        T setCustomColorPickerEnabled(boolean z);

        T setDefaultOutlineColor(int i);
    }

    boolean customColorPickerEnabled();

    List<Integer> getAvailableOutlineColors();

    int getDefaultOutlineColor();
}

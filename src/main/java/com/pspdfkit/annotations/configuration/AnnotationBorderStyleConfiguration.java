package com.pspdfkit.annotations.configuration;

import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationBorderStyleConfiguration extends AnnotationConfiguration {

    public interface Builder<T> extends AnnotationConfiguration.Builder<T> {
        T setBorderStylePresets(List<BorderStylePreset> list);

        T setDefaultBorderStylePreset(BorderStylePreset borderStylePreset);
    }

    List<BorderStylePreset> getBorderStylePresets();

    BorderStylePreset getDefaultBorderStylePreset();
}

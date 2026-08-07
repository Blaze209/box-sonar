package com.pspdfkit.ui.special_mode.controller;

import com.pspdfkit.configuration.theming.AnnotationSelectionViewThemeConfiguration;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationSelectionController {
    AnnotationSelectionViewThemeConfiguration getAnnotationSelectionViewThemeConfiguration();

    boolean isDraggingEnabled();

    Boolean isKeepAspectRatioEnabled();

    boolean isResizeEnabled();

    boolean isResizeGuidesEnabled();

    boolean isRotationEnabled();

    void setAnnotationSelectionViewThemeConfiguration(AnnotationSelectionViewThemeConfiguration annotationSelectionViewThemeConfiguration);

    void setDraggingEnabled(boolean z);

    void setKeepAspectRatioEnabled(boolean z);

    void setResizeEnabled(boolean z);

    void setResizeGuidesEnabled(boolean z);

    void setRotationEnabled(boolean z);
}

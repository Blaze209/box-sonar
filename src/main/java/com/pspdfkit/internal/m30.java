package com.pspdfkit.internal;

import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;

/* JADX INFO: loaded from: classes3.dex */
public interface m30 {
    void enterAnnotatingMode(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant);

    void exitCurrentlyActiveMode();
}

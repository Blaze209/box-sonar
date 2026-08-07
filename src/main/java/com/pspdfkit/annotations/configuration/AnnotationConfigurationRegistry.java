package com.pspdfkit.annotations.configuration;

import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationConfigurationRegistry {
    AnnotationConfiguration get(AnnotationType annotationType);

    <T extends AnnotationConfiguration> T get(AnnotationType annotationType, Class<T> cls);

    AnnotationConfiguration get(AnnotationTool annotationTool);

    AnnotationConfiguration get(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant);

    <T extends AnnotationConfiguration> T get(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, Class<T> cls);

    <T extends AnnotationConfiguration> T get(AnnotationTool annotationTool, Class<T> cls);

    boolean isAnnotationPropertySupported(AnnotationType annotationType, AnnotationProperty annotationProperty);

    boolean isAnnotationPropertySupported(AnnotationTool annotationTool, AnnotationProperty annotationProperty);

    boolean isAnnotationPropertySupported(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, AnnotationProperty annotationProperty);

    boolean isZIndexEditingSupported(AnnotationType annotationType);

    void put(AnnotationType annotationType, AnnotationConfiguration annotationConfiguration);

    void put(AnnotationTool annotationTool, AnnotationConfiguration annotationConfiguration);

    void put(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, AnnotationConfiguration annotationConfiguration);
}

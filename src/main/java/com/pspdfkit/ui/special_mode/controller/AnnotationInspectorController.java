package com.pspdfkit.ui.special_mode.controller;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationInspectorController {
    default void displayScalePicker(boolean z) {
    }

    boolean hasAnnotationInspector();

    void hideAnnotationInspector(boolean z);

    boolean isAnnotationInspectorVisible();

    void showAnnotationInspector(boolean z);

    void toggleAnnotationInspector(boolean z);
}

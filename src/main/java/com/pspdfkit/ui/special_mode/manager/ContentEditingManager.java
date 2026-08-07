package com.pspdfkit.ui.special_mode.manager;

import com.pspdfkit.contentediting.models.StyleInfo;
import com.pspdfkit.contentediting.models.TextBlockStyleInfo;
import com.pspdfkit.ui.special_mode.controller.ContentEditingController;

/* JADX INFO: loaded from: classes3.dex */
public interface ContentEditingManager {

    public interface OnContentEditingContentChangeListener {
        default void onContentChange(String str) {
        }

        default void onContentSelectionChange(String str, int i, int i2, StyleInfo styleInfo, boolean z) {
        }

        default void onFinishEditingContentBlock(String str) {
        }

        default void onStartEditingContentBlock(String str) {
        }

        default void onTextBlockStyleChange(String str, TextBlockStyleInfo textBlockStyleInfo) {
        }
    }

    public interface OnContentEditingModeChangeListener {
        void onEnterContentEditingMode(ContentEditingController contentEditingController);

        void onExitContentEditingMode(ContentEditingController contentEditingController);
    }

    void addOnContentEditingContentChangeListener(OnContentEditingContentChangeListener onContentEditingContentChangeListener);

    void addOnContentEditingModeChangeListener(OnContentEditingModeChangeListener onContentEditingModeChangeListener);

    void removeOnContentEditingContentChangeListener(OnContentEditingContentChangeListener onContentEditingContentChangeListener);

    void removeOnContentEditingModeChangeListener(OnContentEditingModeChangeListener onContentEditingModeChangeListener);
}

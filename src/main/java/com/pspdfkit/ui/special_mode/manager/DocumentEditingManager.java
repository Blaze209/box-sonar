package com.pspdfkit.ui.special_mode.manager;

import com.pspdfkit.ui.special_mode.controller.DocumentEditingController;

/* JADX INFO: loaded from: classes3.dex */
public interface DocumentEditingManager {

    public interface OnDocumentEditingModeChangeListener {
        void onEnterDocumentEditingMode(DocumentEditingController documentEditingController);

        void onExitDocumentEditingMode(DocumentEditingController documentEditingController);
    }

    public interface OnDocumentEditingPageSelectionChangeListener {
        void onDocumentEditingPageSelectionChanged(DocumentEditingController documentEditingController);
    }

    void addOnDocumentEditingModeChangeListener(OnDocumentEditingModeChangeListener onDocumentEditingModeChangeListener);

    void addOnDocumentEditingPageSelectionChangeListener(OnDocumentEditingPageSelectionChangeListener onDocumentEditingPageSelectionChangeListener);

    void removeOnDocumentEditingModeChangeListener(OnDocumentEditingModeChangeListener onDocumentEditingModeChangeListener);

    void removeOnDocumentEditingPageSelectionChangeListener(OnDocumentEditingPageSelectionChangeListener onDocumentEditingPageSelectionChangeListener);
}

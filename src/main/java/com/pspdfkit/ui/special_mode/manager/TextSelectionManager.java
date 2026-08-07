package com.pspdfkit.ui.special_mode.manager;

import com.pspdfkit.datastructures.TextSelection;
import com.pspdfkit.ui.special_mode.controller.TextSelectionController;

/* JADX INFO: loaded from: classes3.dex */
public interface TextSelectionManager {

    public interface OnTextSelectionChangeListener {
        void onAfterTextSelectionChange(TextSelection textSelection, TextSelection textSelection2);

        boolean onBeforeTextSelectionChange(TextSelection textSelection, TextSelection textSelection2);
    }

    public interface OnTextSelectionModeChangeListener {
        void onEnterTextSelectionMode(TextSelectionController textSelectionController);

        void onExitTextSelectionMode(TextSelectionController textSelectionController);
    }

    void addOnTextSelectionChangeListener(OnTextSelectionChangeListener onTextSelectionChangeListener);

    void addOnTextSelectionModeChangeListener(OnTextSelectionModeChangeListener onTextSelectionModeChangeListener);

    void removeOnTextSelectionChangeListener(OnTextSelectionChangeListener onTextSelectionChangeListener);

    void removeOnTextSelectionModeChangeListener(OnTextSelectionModeChangeListener onTextSelectionModeChangeListener);
}

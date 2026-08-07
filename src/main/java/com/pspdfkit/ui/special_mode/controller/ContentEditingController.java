package com.pspdfkit.ui.special_mode.controller;

import com.pspdfkit.contentediting.ContentEditingFormatter;
import com.pspdfkit.contentediting.models.StyleInfo;
import com.pspdfkit.contentediting.models.TextBlockStyleInfo;
import com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController;
import com.pspdfkit.ui.special_mode.controller.base.FragmentSpecialModeController;
import com.pspdfkit.ui.special_mode.manager.ContentEditingManager;
import com.pspdfkit.undo.UndoManager;

/* JADX INFO: loaded from: classes3.dex */
public interface ContentEditingController extends FragmentSpecialModeController, PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener {
    void bindContentEditingInspectorController(ContentEditingInspectorController contentEditingInspectorController);

    void clearContentEditing();

    void displayColorPicker(StyleInfo styleInfo);

    void displayFontNamesSheet(StyleInfo styleInfo);

    void displayFontSizesSheet(StyleInfo styleInfo);

    void displayLineSpacingSheet(Float f);

    void finishContentEditingSession();

    void finishContentEditingSession(boolean z);

    ContentEditingStylingBarItem getActiveContentEditingStylingItem();

    ContentEditingManager getContentEditingManager();

    ContentEditingFormatter getCurrentFormatter();

    StyleInfo getCurrentStyleInfo();

    TextBlockStyleInfo getCurrentTextBlockStyleInfo();

    UndoManager getUndoManager();

    boolean hasUnsavedChanges();

    boolean isBoldStyleButtonEnabled(StyleInfo styleInfo);

    boolean isClearContentEditingEnabled();

    boolean isItalicStyleButtonEnabled(StyleInfo styleInfo);

    default boolean isRedoEnabled() {
        return getUndoManager().canRedo();
    }

    boolean isSaveEnabled();

    default boolean isUndoEnabled() {
        return getUndoManager().canUndo();
    }

    void unbindContentEditingInspectorController();
}

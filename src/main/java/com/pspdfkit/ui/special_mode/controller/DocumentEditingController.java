package com.pspdfkit.ui.special_mode.controller;

import android.content.Context;
import android.view.View;
import com.pspdfkit.ui.special_mode.controller.base.ThumbnailGridSpecialModeController;
import com.pspdfkit.ui.special_mode.manager.DocumentEditingManager;
import com.pspdfkit.undo.EditingChange;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface DocumentEditingController extends ThumbnailGridSpecialModeController {
    void duplicateSelectedPages();

    void exportSelectedPages(Context context);

    DocumentEditingManager getDocumentEditingManager();

    Set<Integer> getSelectedPages();

    void importDocument(Context context);

    boolean isDocumentEmpty();

    boolean isExportEnabled();

    boolean isRedoEnabled();

    boolean isSaveAsEnabled();

    boolean isUndoEnabled();

    void performSaving(Context context, View view);

    List<EditingChange> redo();

    void removeSelectedPages();

    void rotateSelectedPages();

    void setSelectedPages(Set<Integer> set);

    List<EditingChange> undo();
}

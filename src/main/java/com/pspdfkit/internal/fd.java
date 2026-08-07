package com.pspdfkit.internal;

import android.os.Looper;
import com.pspdfkit.ui.special_mode.controller.DocumentEditingController;
import com.pspdfkit.ui.special_mode.manager.DocumentEditingManager;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class fd implements DocumentEditingManager, DocumentEditingManager.OnDocumentEditingPageSelectionChangeListener, DocumentEditingManager.OnDocumentEditingModeChangeListener {
    public final go<DocumentEditingManager.OnDocumentEditingModeChangeListener> a = new go<>();
    public final go<DocumentEditingManager.OnDocumentEditingPageSelectionChangeListener> b = new go<>();

    @Override // com.pspdfkit.ui.special_mode.manager.DocumentEditingManager
    public final void addOnDocumentEditingModeChangeListener(DocumentEditingManager.OnDocumentEditingModeChangeListener onDocumentEditingModeChangeListener) {
        this.a.a(onDocumentEditingModeChangeListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.DocumentEditingManager
    public final void addOnDocumentEditingPageSelectionChangeListener(DocumentEditingManager.OnDocumentEditingPageSelectionChangeListener onDocumentEditingPageSelectionChangeListener) {
        this.b.a(onDocumentEditingPageSelectionChangeListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.DocumentEditingManager
    public final void removeOnDocumentEditingModeChangeListener(DocumentEditingManager.OnDocumentEditingModeChangeListener onDocumentEditingModeChangeListener) {
        this.a.b(onDocumentEditingModeChangeListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.DocumentEditingManager
    public final void removeOnDocumentEditingPageSelectionChangeListener(DocumentEditingManager.OnDocumentEditingPageSelectionChangeListener onDocumentEditingPageSelectionChangeListener) {
        this.b.b(onDocumentEditingPageSelectionChangeListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.DocumentEditingManager.OnDocumentEditingPageSelectionChangeListener
    public final void onDocumentEditingPageSelectionChanged(DocumentEditingController documentEditingController) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("Document Editing listeners touched on non ui thread.");
        }
        Iterator<DocumentEditingManager.OnDocumentEditingPageSelectionChangeListener> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().onDocumentEditingPageSelectionChanged(documentEditingController);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.DocumentEditingManager.OnDocumentEditingModeChangeListener
    public final void onEnterDocumentEditingMode(DocumentEditingController documentEditingController) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("Document Editing listeners touched on non ui thread.");
        }
        Iterator<DocumentEditingManager.OnDocumentEditingModeChangeListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onEnterDocumentEditingMode(documentEditingController);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.DocumentEditingManager.OnDocumentEditingModeChangeListener
    public final void onExitDocumentEditingMode(DocumentEditingController documentEditingController) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("Document Editing listeners touched on non ui thread.");
        }
        Iterator<DocumentEditingManager.OnDocumentEditingModeChangeListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onExitDocumentEditingMode(documentEditingController);
        }
    }
}

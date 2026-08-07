package com.pspdfkit.ui;

import com.pspdfkit.document.printing.PrintOptionsProvider;
import com.pspdfkit.document.sharing.SharingOptionsProvider;
import com.pspdfkit.ui.actionmenu.ActionMenuListener;
import com.pspdfkit.ui.dialog.DocumentPrintDialogFactory;
import com.pspdfkit.ui.dialog.DocumentSharingDialogFactory;
import com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayout;
import com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController;
import com.pspdfkit.ui.inspector.annotation.AnnotatingInspectorController;
import com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayout;

/* JADX INFO: loaded from: classes3.dex */
interface PdfActivityComponentsApi {
    void addPropertyInspectorLifecycleListener(PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener propertyInspectorLifecycleListener);

    PropertyInspectorCoordinatorLayout getPropertyInspectorCoordinator();

    void removePropertyInspectorLifecycleListener(PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener propertyInspectorLifecycleListener);

    void setCreationInspectorController(AnnotatingInspectorController annotatingInspectorController);

    void setDocumentPrintDialogFactory(DocumentPrintDialogFactory documentPrintDialogFactory);

    void setDocumentSharingDialogFactory(DocumentSharingDialogFactory documentSharingDialogFactory);

    void setEditingInspectorController(AnnotatingInspectorController annotatingInspectorController);

    void setOnContextualToolbarLifecycleListener(ToolbarCoordinatorLayout.OnContextualToolbarLifecycleListener onContextualToolbarLifecycleListener);

    void setOnContextualToolbarMovementListener(ToolbarCoordinatorLayout.OnContextualToolbarMovementListener onContextualToolbarMovementListener);

    void setOnContextualToolbarPositionListener(ToolbarCoordinatorLayout.OnContextualToolbarPositionListener onContextualToolbarPositionListener);

    void setPrintOptionsProvider(PrintOptionsProvider printOptionsProvider);

    void setSharingActionMenuListener(ActionMenuListener actionMenuListener);

    void setSharingOptionsProvider(SharingOptionsProvider sharingOptionsProvider);
}

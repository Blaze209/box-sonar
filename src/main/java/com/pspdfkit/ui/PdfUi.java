package com.pspdfkit.ui;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Looper;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.configuration.activity.UserInterfaceViewMode;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.printing.PrintOptionsProvider;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.document.sharing.SharingOptionsProvider;
import com.pspdfkit.internal.av;
import com.pspdfkit.internal.cw;
import com.pspdfkit.internal.jv;
import com.pspdfkit.internal.uw;
import com.pspdfkit.listeners.OnMenuItemsGenerateListener;
import com.pspdfkit.listeners.OnToolbarMenuChangedListener;
import com.pspdfkit.listeners.PdfActivityListener;
import com.pspdfkit.ui.actionmenu.ActionMenuListener;
import com.pspdfkit.ui.dialog.DocumentPrintDialogFactory;
import com.pspdfkit.ui.dialog.DocumentSharingDialogFactory;
import com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayout;
import com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController;
import com.pspdfkit.ui.inspector.annotation.AnnotatingInspectorController;
import com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public interface PdfUi extends PdfActivityListener, OnMenuItemsGenerateListener, av.a, PdfActivityComponentsApi {
    public static final long TIMEOUT_DEFAULT = 0;
    public static final long TIMEOUT_INFINITE = Long.MAX_VALUE;

    @Override // com.pspdfkit.ui.PdfActivityComponentsApi
    default void addPropertyInspectorLifecycleListener(PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener propertyInspectorLifecycleListener) {
        uw.a(propertyInspectorLifecycleListener, "lifecycleListener", null);
        getImplementation().getPropertyInspectorCoordinatorLayout().addPropertyInspectorLifecycleListener(propertyInspectorLifecycleListener);
    }

    PdfActivityConfiguration getConfiguration();

    default PdfDocument getDocument() {
        if (getPdfFragment() == null) {
            return null;
        }
        return getPdfFragment().getDocument();
    }

    default DocumentCoordinator getDocumentCoordinator() {
        return getImplementation().getDocumentCoordinator();
    }

    cw getImplementation();

    default PSPDFKitViews getPSPDFKitViews() {
        return getImplementation().getViews();
    }

    default int getPageIndex() {
        return getImplementation().getPageIndex();
    }

    default PdfFragment getPdfFragment() {
        return ((jv) getImplementation().getViews()).a;
    }

    @Override // com.pspdfkit.ui.PdfActivityComponentsApi
    default PropertyInspectorCoordinatorLayout getPropertyInspectorCoordinator() {
        return getImplementation().getPropertyInspectorCoordinatorLayout();
    }

    default long getScreenTimeout() {
        return getImplementation().getScreenTimeout();
    }

    default int getSiblingPageIndex(int i) {
        return getImplementation().getSiblingPageIndex(i);
    }

    default UserInterfaceViewMode getUserInterfaceViewMode() {
        return getImplementation().getUserInterfaceCoordinator().o;
    }

    default void hideUserInterface() {
        getImplementation().getUserInterfaceCoordinator().hideUserInterface();
    }

    default void invalidateMenu() {
        getImplementation().invalidateMenu();
    }

    default boolean isDocumentInteractionEnabled() {
        return getImplementation().isDocumentInteractionEnabled();
    }

    default boolean isImageDocument() {
        return getImplementation().getFragment() != null && getImplementation().getFragment().isImageDocument();
    }

    default boolean isUserInterfaceEnabled() {
        return getImplementation().isUserInterfaceEnabled();
    }

    default boolean isUserInterfaceVisible() {
        return getImplementation().getUserInterfaceCoordinator().l;
    }

    default void onConfigurationChanged(Configuration configuration) {
        getImplementation().onConfigurationChanged(configuration);
    }

    /* synthetic */ int onGetShowAsAction(int i, int i2);

    @Override // com.pspdfkit.ui.PdfActivityComponentsApi
    default void removePropertyInspectorLifecycleListener(PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener propertyInspectorLifecycleListener) {
        uw.a(propertyInspectorLifecycleListener, "lifecycleListener", null);
        getImplementation().getPropertyInspectorCoordinatorLayout().removePropertyInspectorLifecycleListener(propertyInspectorLifecycleListener);
    }

    default PdfFragment requirePdfFragment() {
        PdfFragment pdfFragment = getPdfFragment();
        uw.b(pdfFragment != null, "PdfFragment is not initialized yet!");
        return pdfFragment;
    }

    void setConfiguration(PdfActivityConfiguration pdfActivityConfiguration);

    @Override // com.pspdfkit.ui.PdfActivityComponentsApi
    default void setCreationInspectorController(AnnotatingInspectorController annotatingInspectorController) {
        uw.a(annotatingInspectorController, "creationInspectorController", null);
        getImplementation().setCreationInspectorController(annotatingInspectorController);
    }

    default void setDocumentFromDataProvider(DataProvider dataProvider, String str) {
        uw.a(dataProvider, "dataProvider", null);
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("setDocumentFromDataProvider() may only be called from the UI thread.");
        }
        getDocumentCoordinator().setDocument(DocumentDescriptor.fromDataProvider(dataProvider, str, null));
    }

    default void setDocumentFromDataProviders(List<DataProvider> list, List<String> list2) {
        uw.a(list, "dataProviders", null);
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("setDocumentFromDataProvider() may only be called from the UI thread.");
        }
        getDocumentCoordinator().setDocument(DocumentDescriptor.fromDataProviders(list, list2, null));
    }

    default void setDocumentFromUri(Uri uri, String str) throws IllegalStateException {
        ArrayList arrayList = null;
        uw.a(uri, "documentUri", null);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList2.add(uri);
        if (str != null) {
            arrayList = new ArrayList(1);
            arrayList.add(str);
        }
        setDocumentFromUris(arrayList2, arrayList);
    }

    default void setDocumentFromUris(List<Uri> list, List<String> list2) {
        uw.a(list, "documentUris", null);
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("setDocumentFromUris() may only be called from the UI thread.");
        }
        getDocumentCoordinator().setDocument(DocumentDescriptor.fromUris(list, list2, null));
    }

    default void setDocumentInteractionEnabled(boolean z) {
        getImplementation().setDocumentInteractionEnabled(z);
    }

    @Override // com.pspdfkit.ui.PdfActivityComponentsApi
    default void setDocumentPrintDialogFactory(DocumentPrintDialogFactory documentPrintDialogFactory) {
        getImplementation().setDocumentPrintDialogFactory(documentPrintDialogFactory);
    }

    @Override // com.pspdfkit.ui.PdfActivityComponentsApi
    default void setDocumentSharingDialogFactory(DocumentSharingDialogFactory documentSharingDialogFactory) {
        getImplementation().setDocumentSharingDialogFactory(documentSharingDialogFactory);
    }

    @Override // com.pspdfkit.ui.PdfActivityComponentsApi
    default void setEditingInspectorController(AnnotatingInspectorController annotatingInspectorController) {
        uw.a(annotatingInspectorController, "editingInspectorController", null);
        getImplementation().setEditingInspectorController(annotatingInspectorController);
    }

    @Override // com.pspdfkit.ui.PdfActivityComponentsApi
    default void setOnContextualToolbarLifecycleListener(ToolbarCoordinatorLayout.OnContextualToolbarLifecycleListener onContextualToolbarLifecycleListener) {
        getImplementation().setOnContextualToolbarLifecycleListener(onContextualToolbarLifecycleListener);
    }

    @Override // com.pspdfkit.ui.PdfActivityComponentsApi
    default void setOnContextualToolbarMovementListener(ToolbarCoordinatorLayout.OnContextualToolbarMovementListener onContextualToolbarMovementListener) {
        getImplementation().setOnContextualToolbarMovementListener(onContextualToolbarMovementListener);
    }

    @Override // com.pspdfkit.ui.PdfActivityComponentsApi
    default void setOnContextualToolbarPositionListener(ToolbarCoordinatorLayout.OnContextualToolbarPositionListener onContextualToolbarPositionListener) {
        getImplementation().setOnContextualToolbarPositionListener(onContextualToolbarPositionListener);
    }

    default void setOnToolbarMenuChangedListener(OnToolbarMenuChangedListener onToolbarMenuChangedListener) {
        getImplementation().setOnToolbarMenuChangedListener(onToolbarMenuChangedListener);
    }

    default void setPageIndex(int i) {
        getImplementation().setPageIndex(i);
    }

    @Override // com.pspdfkit.ui.PdfActivityComponentsApi
    default void setPrintOptionsProvider(PrintOptionsProvider printOptionsProvider) {
        getImplementation().setPrintOptionsProvider(printOptionsProvider);
    }

    default void setScreenTimeout(long j) {
        getImplementation().setScreenTimeout(j);
    }

    @Override // com.pspdfkit.ui.PdfActivityComponentsApi
    default void setSharingActionMenuListener(ActionMenuListener actionMenuListener) {
        getImplementation().setSharingActionMenuListener(actionMenuListener);
    }

    @Override // com.pspdfkit.ui.PdfActivityComponentsApi
    default void setSharingOptionsProvider(SharingOptionsProvider sharingOptionsProvider) {
        getImplementation().setSharingOptionsProvider(sharingOptionsProvider);
    }

    default void setUserInterfaceEnabled(boolean z) {
        getImplementation().setUserInterfaceEnabled(z);
    }

    default void setUserInterfaceViewMode(UserInterfaceViewMode userInterfaceViewMode) {
        getImplementation().getUserInterfaceCoordinator().setUserInterfaceViewMode(userInterfaceViewMode);
    }

    default void setUserInterfaceVisible(boolean z, boolean z2) {
        getImplementation().getUserInterfaceCoordinator().a(false, z, z2);
    }

    default void showUserInterface() {
        getImplementation().getUserInterfaceCoordinator().showUserInterface();
    }

    default void toggleUserInterface() {
        getImplementation().getUserInterfaceCoordinator().toggleUserInterface();
    }

    default void setPageIndex(int i, boolean z) {
        getImplementation().setPageIndex(i, z);
    }
}

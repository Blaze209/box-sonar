package com.pspdfkit.internal;

import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.listeners.DocumentListener;

/* JADX INFO: loaded from: classes3.dex */
public interface rm {
    void addUserInterfaceListener(k70 k70Var);

    go<DocumentListener> getDocumentListeners();

    uv getViewCoordinator();

    boolean isLastViewedPageRestorationActiveAndIsConfigChange();

    void removeUserInterfaceListener(k70 k70Var);

    void setDocument(PdfDocument pdfDocument);
}

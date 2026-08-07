package com.pspdfkit.instant.listeners;

import com.pspdfkit.instant.document.InstantDocumentState;
import com.pspdfkit.instant.document.InstantPdfDocument;
import com.pspdfkit.instant.exceptions.InstantException;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class SimpleInstantDocumentListener implements InstantDocumentListener {
    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onAuthenticationFailed(InstantPdfDocument instantPdfDocument, InstantException instantException) {
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onAuthenticationFinished(InstantPdfDocument instantPdfDocument, String str) {
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onDocumentCorrupted(InstantPdfDocument instantPdfDocument) {
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onDocumentInvalidated(InstantPdfDocument instantPdfDocument) {
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onDocumentStateChanged(InstantPdfDocument instantPdfDocument, InstantDocumentState instantDocumentState) {
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onSyncError(InstantPdfDocument instantPdfDocument, InstantException instantException) {
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onSyncFinished(InstantPdfDocument instantPdfDocument) {
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onSyncStarted(InstantPdfDocument instantPdfDocument) {
    }
}

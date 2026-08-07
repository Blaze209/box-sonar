package com.pspdfkit.instant.listeners;

import com.pspdfkit.instant.document.InstantDocumentState;
import com.pspdfkit.instant.document.InstantPdfDocument;
import com.pspdfkit.instant.exceptions.InstantException;

/* JADX INFO: loaded from: classes3.dex */
public interface InstantDocumentListener {
    default void onAuthenticationFailed(InstantPdfDocument instantPdfDocument, InstantException instantException) {
    }

    default void onAuthenticationFinished(InstantPdfDocument instantPdfDocument, String str) {
    }

    default void onDocumentCorrupted(InstantPdfDocument instantPdfDocument) {
    }

    default void onDocumentInvalidated(InstantPdfDocument instantPdfDocument) {
    }

    default void onDocumentStateChanged(InstantPdfDocument instantPdfDocument, InstantDocumentState instantDocumentState) {
    }

    default void onSyncError(InstantPdfDocument instantPdfDocument, InstantException instantException) {
    }

    default void onSyncFinished(InstantPdfDocument instantPdfDocument) {
    }

    default void onSyncStarted(InstantPdfDocument instantPdfDocument) {
    }
}

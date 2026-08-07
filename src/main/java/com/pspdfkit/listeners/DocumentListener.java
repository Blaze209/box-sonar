package com.pspdfkit.listeners;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.document.DocumentSaveOptions;
import com.pspdfkit.document.PdfDocument;

/* JADX INFO: loaded from: classes3.dex */
public interface DocumentListener {
    default boolean onDocumentClick() {
        return false;
    }

    default void onDocumentLoadFailed(Throwable th) {
    }

    default void onDocumentLoaded(PdfDocument pdfDocument) {
    }

    default boolean onDocumentSave(PdfDocument pdfDocument, DocumentSaveOptions documentSaveOptions) {
        return true;
    }

    default void onDocumentSaveCancelled(PdfDocument pdfDocument) {
    }

    default void onDocumentSaveFailed(PdfDocument pdfDocument, Throwable th) {
    }

    default void onDocumentSaved(PdfDocument pdfDocument) {
    }

    default void onDocumentZoomed(PdfDocument pdfDocument, int i, float f) {
    }

    default void onPageChanged(PdfDocument pdfDocument, int i) {
    }

    default boolean onPageClick(PdfDocument pdfDocument, int i, MotionEvent motionEvent, PointF pointF, Annotation annotation) {
        return false;
    }

    default void onPageUpdated(PdfDocument pdfDocument, int i) {
    }
}

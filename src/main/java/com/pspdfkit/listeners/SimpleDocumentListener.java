package com.pspdfkit.listeners;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.document.DocumentSaveOptions;
import com.pspdfkit.document.PdfDocument;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class SimpleDocumentListener implements DocumentListener {
    @Override // com.pspdfkit.listeners.DocumentListener
    public boolean onDocumentClick() {
        return false;
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onDocumentLoadFailed(Throwable th) {
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onDocumentLoaded(PdfDocument pdfDocument) {
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public boolean onDocumentSave(PdfDocument pdfDocument, DocumentSaveOptions documentSaveOptions) {
        return true;
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onDocumentSaveCancelled(PdfDocument pdfDocument) {
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onDocumentSaveFailed(PdfDocument pdfDocument, Throwable th) {
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onDocumentSaved(PdfDocument pdfDocument) {
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onDocumentZoomed(PdfDocument pdfDocument, int i, float f) {
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onPageChanged(PdfDocument pdfDocument, int i) {
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public boolean onPageClick(PdfDocument pdfDocument, int i, MotionEvent motionEvent, PointF pointF, Annotation annotation) {
        return false;
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onPageUpdated(PdfDocument pdfDocument, int i) {
    }
}

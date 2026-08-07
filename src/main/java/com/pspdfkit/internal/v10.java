package com.pspdfkit.internal;

import com.pspdfkit.document.DocumentSaveOptions;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.listeners.InternalDocumentListener;

/* JADX INFO: loaded from: classes3.dex */
public final class v10 implements InternalDocumentListener {
    @Override // com.pspdfkit.listeners.DocumentListener
    public final boolean onDocumentSave(PdfDocument pdfDocument, DocumentSaveOptions documentSaveOptions) {
        pdfDocument.getClass();
        documentSaveOptions.getClass();
        return false;
    }
}

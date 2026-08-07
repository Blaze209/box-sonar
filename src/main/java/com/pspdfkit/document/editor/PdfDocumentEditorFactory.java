package com.pspdfkit.document.editor;

import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.gd;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.uw;

/* JADX INFO: loaded from: classes3.dex */
public class PdfDocumentEditorFactory {
    public static PdfDocumentEditor createForDocument(PdfDocument pdfDocument) {
        uw.a(pdfDocument, "document", null);
        return new gd((lm) pdfDocument);
    }
}

package com.pspdfkit.document.editor.page;

import android.graphics.drawable.Drawable;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.processor.PagePattern;
import com.pspdfkit.internal.uw;

/* JADX INFO: loaded from: classes3.dex */
public final class PageTemplate {
    final int pageIndex;
    final PagePattern pagePattern;
    final Drawable previewImage;
    final PdfDocument sourceDocument;
    final String templateName;

    public PageTemplate(PdfDocument pdfDocument, int i, String str, Drawable drawable) {
        uw.a(pdfDocument, "sourceDocument", null);
        uw.a(str, "templateName", null);
        this.sourceDocument = pdfDocument;
        this.pageIndex = i;
        this.previewImage = drawable;
        this.templateName = str;
        this.pagePattern = null;
    }

    public PageTemplate(PagePattern pagePattern, String str, Drawable drawable) {
        uw.a(pagePattern, "pagePattern", null);
        uw.a(str, "templateName", null);
        this.sourceDocument = null;
        this.pageIndex = 0;
        this.pagePattern = pagePattern;
        this.previewImage = drawable;
        this.templateName = str;
    }
}

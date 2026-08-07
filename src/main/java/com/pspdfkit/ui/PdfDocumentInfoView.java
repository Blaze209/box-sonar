package com.pspdfkit.ui;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes3.dex */
public class PdfDocumentInfoView extends PdfOutlineView {
    public PdfDocumentInfoView(Context context) {
        super(context);
    }

    @Override // com.pspdfkit.ui.PdfOutlineView
    public boolean getMayContainDocumentInfoView() {
        return true;
    }

    @Override // com.pspdfkit.ui.PdfOutlineView, com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public PSPDFKitViews.Type getPSPDFViewType() {
        return PSPDFKitViews.Type.VIEW_DOCUMENT_INFO;
    }

    @Override // com.pspdfkit.ui.PdfOutlineView
    public boolean shouldDisplayAnnotationListView() {
        return false;
    }

    @Override // com.pspdfkit.ui.PdfOutlineView
    public boolean shouldDisplayBookmarkListView() {
        return false;
    }

    @Override // com.pspdfkit.ui.PdfOutlineView
    public boolean shouldDisplayEmbeddedFilesView() {
        return false;
    }

    @Override // com.pspdfkit.ui.PdfOutlineView
    public boolean shouldDisplayOutlineView() {
        return false;
    }

    public PdfDocumentInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PdfDocumentInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

package com.pspdfkit.ui.tabs;

import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.DocumentDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public class PdfTabBarItem {
    private final DocumentDescriptor documentDescriptor;

    public PdfTabBarItem(DocumentDescriptor documentDescriptor) {
        uw.a(documentDescriptor, "documentDescriptor", null);
        this.documentDescriptor = documentDescriptor;
    }

    public DocumentDescriptor getDocumentDescriptor() {
        return this.documentDescriptor;
    }
}

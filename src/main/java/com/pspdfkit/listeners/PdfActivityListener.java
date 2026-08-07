package com.pspdfkit.listeners;

import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.document.PdfDocument;

/* JADX INFO: loaded from: classes3.dex */
public interface PdfActivityListener extends DocumentListener {
    void onSetActivityTitle(PdfActivityConfiguration pdfActivityConfiguration, PdfDocument pdfDocument);

    void onUserInterfaceVisibilityChanged(boolean z);
}

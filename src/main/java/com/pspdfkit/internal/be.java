package com.pspdfkit.internal;

import androidx.fragment.app.FragmentActivity;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.printing.PrintOptionsProvider;
import com.pspdfkit.ui.dialog.DocumentPrintDialogFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class be {
    public final PdfDocument a;
    public FragmentActivity b;
    public boolean c;
    public final DocumentPrintDialogFactory d;
    public final PrintOptionsProvider e;

    public be(FragmentActivity fragmentActivity, PdfDocument pdfDocument, DocumentPrintDialogFactory documentPrintDialogFactory, PrintOptionsProvider printOptionsProvider, int i, String str) {
        this.b = fragmentActivity;
        this.a = pdfDocument;
        this.d = documentPrintDialogFactory;
        this.e = printOptionsProvider;
    }
}

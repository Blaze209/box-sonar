package com.pspdfkit.internal;

import androidx.fragment.app.FragmentActivity;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.sharing.DocumentSharingController;
import com.pspdfkit.document.sharing.ShareAction;
import com.pspdfkit.ui.dialog.DocumentSharingDialogFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class le {
    public final PdfDocument a;
    public final ShareAction b;
    public FragmentActivity c;
    public DocumentSharingController d;
    public final DocumentSharingDialogFactory e;
    public boolean f;

    public le(FragmentActivity fragmentActivity, PdfDocument pdfDocument, DocumentSharingDialogFactory documentSharingDialogFactory, ShareAction shareAction, int i, String str) {
        this.c = fragmentActivity;
        this.a = pdfDocument;
        this.e = documentSharingDialogFactory;
        this.b = shareAction;
    }
}

package com.pspdfkit.internal;

import android.text.TextUtils;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.ActionSender;
import com.pspdfkit.annotations.actions.GoToEmbeddedAction;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.files.EmbeddedFilesProvider;
import com.pspdfkit.ui.PdfFragment;

/* JADX INFO: loaded from: classes3.dex */
public final class gj implements c<GoToEmbeddedAction> {
    public final PdfFragment a;

    public gj(PdfFragment pdfFragment) {
        pdfFragment.getClass();
        this.a = pdfFragment;
    }

    @Override // com.pspdfkit.internal.c
    public final boolean executeAction(Action action, ActionSender actionSender) {
        GoToEmbeddedAction goToEmbeddedAction = (GoToEmbeddedAction) action;
        if (TextUtils.isEmpty(goToEmbeddedAction.getPdfPath()) || this.a.getDocument() == null) {
            return false;
        }
        PdfDocument document = this.a.getDocument();
        document.getClass();
        EmbeddedFilesProvider embeddedFilesProvider = document.getEmbeddedFilesProvider();
        String pdfPath = goToEmbeddedAction.getPdfPath();
        pdfPath.getClass();
        embeddedFilesProvider.getEmbeddedFileWithFileNameAsync(pdfPath, true).subscribe(new ej(this, goToEmbeddedAction));
        return true;
    }
}

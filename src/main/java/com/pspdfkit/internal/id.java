package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.R;
import com.pspdfkit.ui.document.editor.DocumentEditorProgressDialog;
import com.pspdfkit.utils.PdfLog;

/* JADX INFO: loaded from: classes3.dex */
public final class id extends u20 {
    public final /* synthetic */ DocumentEditorProgressDialog a;
    public final /* synthetic */ hd b;
    public final /* synthetic */ Context c;

    public id(DocumentEditorProgressDialog documentEditorProgressDialog, hd hdVar, Context context) {
        this.a = documentEditorProgressDialog;
        this.b = hdVar;
        this.c = context;
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        this.a.dismiss();
        this.b.a.onDocumentSaved();
    }

    @Override // com.pspdfkit.internal.u20, io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        th.getClass();
        this.a.showErrorDialog(this.c, R.string.pspdf__document_could_not_be_saved);
        PdfLog.e("Nutri.DocEdiSavTBarHand", th, "Document couldn't be saved.", new Object[0]);
    }
}

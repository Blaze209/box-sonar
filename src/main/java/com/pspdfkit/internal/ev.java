package com.pspdfkit.internal;

import com.pspdfkit.ui.DocumentDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public final class ev extends v20 {
    public final /* synthetic */ dv a;

    public ev(dv dvVar) {
        this.a = dvVar;
    }

    @Override // com.pspdfkit.ui.DocumentCoordinator.OnDocumentsChangedListener
    public final void onDocumentAdded(DocumentDescriptor documentDescriptor) {
        documentDescriptor.getClass();
        dv dvVar = this.a;
        if (dvVar.l && dvVar.g()) {
            dvVar.k(true);
        } else {
            dvVar.e(true);
        }
        this.a.m();
    }

    @Override // com.pspdfkit.ui.DocumentCoordinator.OnDocumentsChangedListener
    public final void onDocumentRemoved(DocumentDescriptor documentDescriptor) {
        documentDescriptor.getClass();
        dv dvVar = this.a;
        if (dvVar.l && dvVar.g()) {
            dvVar.k(true);
        } else {
            dvVar.e(true);
        }
        this.a.m();
    }
}

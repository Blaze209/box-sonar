package com.pspdfkit.internal;

import com.pspdfkit.signatures.Signature;
import io.reactivex.rxjava3.functions.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public final class bk<T> implements Consumer {
    public final /* synthetic */ com.pspdfkit.internal.ui.dialog.signatures.d a;

    public bk(com.pspdfkit.internal.ui.dialog.signatures.d dVar) {
        this.a = dVar;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        Signature signature = (Signature) obj;
        signature.getClass();
        com.pspdfkit.internal.ui.dialog.signatures.d dVar = this.a;
        sf sfVar = dVar.a;
        if (sfVar != null) {
            sfVar.onSignatureUiDataCollected(signature, dVar.c.e());
            sfVar.onSignatureCreated(signature, dVar.e.getValue().booleanValue());
        }
    }
}
